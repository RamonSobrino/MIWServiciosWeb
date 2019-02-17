using RestSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PlanAdviser.CitiesService
{
    public class CitiesWheatherService
    {
        private static string API_KEY = "d7d9bf189fad5fffde2d178ae166e9dc";
        private static string FORECAST_ENDPOINT = "http://api.openweathermap.org/data/2.5/forecast";

        private IRestClient restClient;

        public CitiesWheatherService()
        {
            restClient = new RestClient(FORECAST_ENDPOINT);
            restClient.AddHandler("application/json", new DynamicJsonDeserializer());
            restClient.AddDefaultQueryParameter("appid", API_KEY);
            restClient.AddDefaultQueryParameter("units", "metric");
        }

        public dynamic GetForecastByCityName(string cityName, string countryCode = "es")
        {
            var request = new RestRequest(Method.GET);
            request.AddQueryParameter("q", cityName + "," + countryCode);
            request.RequestFormat = DataFormat.Json;
            return restClient.Execute<dynamic>(request).Data;
        }
    }
}