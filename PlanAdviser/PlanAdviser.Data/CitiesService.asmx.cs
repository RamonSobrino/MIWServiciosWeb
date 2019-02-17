using PlanAdviser.CitiesService.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace PlanAdviser.CitiesService
{
    /// <summary>
    /// Data service for PlanAdviser App
    /// </summary>
    [WebService(Namespace = "http://planadviser.data/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    public class CitiesService : System.Web.Services.WebService
    {

        [WebMethod]
        public City[] GetAllCities()
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.CityDAO.All().ToArray();
            }
        }

        [WebMethod]
        public Distance[] GetAllDistances()
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.DistanceDAO.All().ToArray();
            }
        }

        [WebMethod]
        public City[] GetClosestCities(int originCityId, int numberOfCitiesToReturn)
        {
            using (DAOFactory factory = new DAOFactory())
            {
                var nearCitiesFromOrigin = factory.DistanceDAO.All()
                    .Where(distance => distance.OriginCityId == originCityId)
                    .OrderBy(distance => distance.DistanceInKm)
                    .Take(numberOfCitiesToReturn).Select(distance => distance.DestinationCityId);

                var nearCitiesFromDestination = factory.DistanceDAO.All()
                    .Where(distance => distance.DestinationCityId == originCityId)
                    .OrderBy(distance => distance.DistanceInKm)
                    .Take(numberOfCitiesToReturn).Select(distance => distance.OriginCityId);

                ISet<int> nearCitiesIds = new HashSet<int>();
                nearCitiesIds.UnionWith(nearCitiesFromOrigin);
                nearCitiesIds.UnionWith(nearCitiesFromDestination);

                var cities = factory.CityDAO.All().Where(city => nearCitiesIds.Contains(city.Id));
                return cities.ToArray();
            }
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
                    .Select(weather => new CityWeather() {
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
