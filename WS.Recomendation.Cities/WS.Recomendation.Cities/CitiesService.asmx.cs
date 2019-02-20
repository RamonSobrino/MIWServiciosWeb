using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using WS.Recomendation.Cities.DataService;
using WS.Recomendation.Cities.WeatherService.Impl;

namespace WS.Recomendation.Cities
{
    /// <summary>
    /// CitiesService
    /// </summary>
    [WebService(Namespace = "http://WS.Recomendation.Cities/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    public class CitiesService : System.Web.Services.WebService
    {

        [WebMethod]
        public City[] GetClosestCities(int originCityId, int numberOfCitiesToReturn)
        {
            DataServiceSoapClient dataService = new DataServiceSoapClient("DataServiceSoap", "http://156.35.98.19:9091/WS.Recomendation.Data/DataService.asmx");

            var nearCitiesFromOrigin = dataService.GetDistancesByOriginCityId(originCityId)
                    .OrderBy(distance => distance.DistanceInKm)
                    .Take(numberOfCitiesToReturn).Select(distance => distance.DestinationCityId);

            var nearCitiesFromDestination = dataService.GetDistancesByDestinationCityId(originCityId)
                .OrderBy(distance => distance.DistanceInKm)
                .Take(numberOfCitiesToReturn).Select(distance => distance.OriginCityId);

            ISet<int> nearCitiesIds = new HashSet<int>();
            nearCitiesIds.UnionWith(nearCitiesFromOrigin);
            nearCitiesIds.UnionWith(nearCitiesFromDestination);

            var cities = dataService.GetAllCities().Where(city => nearCitiesIds.Contains(city.Id));
            return cities.ToArray();
        }

        [WebMethod]
        public City[] GetClosestCitiesWithWeatcher(int originCityId, int numberOfCitiesToReturn)
        {
            var weatherClient = new CitiesWheatherService();
            var cities = GetClosestCities(originCityId, numberOfCitiesToReturn);
            var indexes = new int[] { 2, 10, 18, 26, 35 };
            return cities.Select(city =>
            {
                var response = weatherClient.GetForecastByCityName(city.Name);
                if ("200".Equals(response.cod.Value))
                {
                    city.Latitude = response.city.coord.lat;
                    city.Longitude = response.city.coord.lon;
                    IEnumerable<dynamic> weatherList = response.list;
                    city.Weather5Days = weatherList
                    .Where((weather, index) => indexes.Contains(index))
                    .Select(weather => new CityWeather()
                    {
                        Temperature = weather.main.temp,
                        Humidity = weather.main.humidity,
                        Description = weather.weather[0].main
                    })
                    .ToArray();
                }
                return city;
            }).ToArray();
        }
    }
}
