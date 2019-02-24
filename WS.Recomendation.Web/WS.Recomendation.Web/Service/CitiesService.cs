using RestSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WS.Recomendation.Web.DataService;
using WS.Recomendation.Web.Models;
using WS.Recomendation.Web.Utils;

namespace WS.Recomendation.Web.Service
{
    public class CitiesService
    {
        private static string FORECAST_ENDPOINT = "http://156.35.95.51:8082/WS.Recomendation/restws/rs";

        private IRestClient restClient;

        public CitiesService()
        {
            restClient = new RestClient(FORECAST_ENDPOINT);
            restClient.AddHandler("application/json", new DynamicJsonDeserializer());
        }

        public IEnumerable<PlaceType> GetTypes()
        {
            return new PlaceType[] {
                new PlaceType() { Value = "MUSEUM", Name = "Museum" },
                new PlaceType() { Value = "CASINO", Name = "Casino" },
                new PlaceType() { Value = "AQUARIUM", Name = "Aquarium" },
                new PlaceType() { Value = "PARK", Name = "Park" },
                new PlaceType() { Value = "SPA", Name = "Spa" },
                new PlaceType() { Value = "NIGHT_CLUB", Name = "Night club" }
            };
        }

        public IEnumerable<City> GetCities()
        {
            DataServiceSoapClient dataService = new DataServiceSoapClient("DataServiceSoap", "http://156.35.98.19:9091/WS.Recomendation.Data/DataService.asmx");
            return dataService.GetAllCities();
        }
        
        public dynamic GetResult(string originCityId, string type)
        {
            var request = new RestRequest(Method.GET);
            request.AddQueryParameter("originCityId", originCityId);
            request.AddQueryParameter("type", type);
            request.RequestFormat = DataFormat.Json;
            return restClient.Execute<dynamic>(request).Data;
        }

    }
}