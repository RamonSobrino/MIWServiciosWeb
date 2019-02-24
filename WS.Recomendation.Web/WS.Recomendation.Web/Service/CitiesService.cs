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
        private static string AUTHENTICATION_LOGIN_ENDPOINT = "http://156.35.98.19:9093/WS.Recomendation.Authentication/User/login";
        //private static string AUTHENTICATION_LOGIN_ENDPOINT = "http://localhost:5000/User/login";

        private static string AUTHENTICATION_REGISTER_ENDPOINT = "http://156.35.98.19:9093/WS.Recomendation.Authentication/User/register";
        //private static string AUTHENTICATION_REGISTER_ENDPOINT = "http://localhost:5000/User/register";

        private static string AUTHENTICATION_FAVCITIES_ENDPOINT = "http://156.35.98.19:9093/WS.Recomendation.Authentication/FavCities";
        //private static string AUTHENTICATION_FAVCITIES_ENDPOINT = "http://localhost:5000/FavCities";



        private IRestClient restClient;
        private IRestClient restClientLogin;
        private IRestClient restClientRegister;
        private IRestClient restClientFavCities;


        public CitiesService()
        {
            restClient = new RestClient(FORECAST_ENDPOINT);
            restClient.AddHandler("application/json", new DynamicJsonDeserializer());
            restClientLogin = new RestClient(AUTHENTICATION_LOGIN_ENDPOINT);
            restClientLogin.AddHandler("application/json", new DynamicJsonDeserializer());
            restClientRegister = new RestClient(AUTHENTICATION_REGISTER_ENDPOINT);
            restClientRegister.AddHandler("application/json", new DynamicJsonDeserializer());
            restClientFavCities = new RestClient(AUTHENTICATION_FAVCITIES_ENDPOINT);
            restClientFavCities.AddHandler("application/json", new DynamicJsonDeserializer());
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

        public dynamic PostLogin(string name, string password)
        {
            var request = new RestRequest(Method.POST);
            request.RequestFormat = DataFormat.Json;
            Object transferir = new
            {
                Name = name,
                Password = password
            };
            request.AddJsonBody(transferir);
            request.AddHeader("Content-Type","application/json");
            var respuesta = restClientLogin.Execute<dynamic>(request);

            if(respuesta.StatusCode == System.Net.HttpStatusCode.OK) { 
                Object dev = new
                {
                    Name = name,
                    Token = respuesta.Content
                };
                return dev;

            }
            else
            {
                return null;
            }
        }

        public dynamic PostRegister(string name, string password)
        {
            var request = new RestRequest(Method.POST);
            request.RequestFormat = DataFormat.Json;
            Object transferir = new
            {
                Name = name,
                Password = password
            };
            request.AddJsonBody(transferir);
            request.AddHeader("Content-Type", "application/json");
            var respuesta = restClientRegister.Execute<dynamic>(request);

            if (respuesta.StatusCode == System.Net.HttpStatusCode.OK)
            {
                Object dev = new
                {
                    Name = name,
                    Token = respuesta.Content
                };
                return dev;

            }
            else
            {
                return null;
            }
        }


        public dynamic PostFavoritos(string idCiudad, string token)
        {
            var request = new RestRequest(Method.POST);
            request.RequestFormat = DataFormat.Json;
            request.AddQueryParameter("ciudad", idCiudad);
            request.AddHeader("Content-Type", "application/json");
            var tokenCortado = token.Substring(1, token.Length -2);
            request.AddHeader("Authorization", tokenCortado);
            var respuesta = restClientFavCities.Execute<dynamic>(request);

            if (respuesta.StatusCode == System.Net.HttpStatusCode.OK)
            {
                return token;
            }
            else
            {
                return null;
            }
        }

    }
}