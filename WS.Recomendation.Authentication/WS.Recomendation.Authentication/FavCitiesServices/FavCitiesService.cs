using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WS.Recomendation.Authentication.ServiceData;
using WS.Recomendation.Authentication.UserServices;

namespace WS.Recomendation.Authentication.FavCitiesServices
{
    public class FavCitiesService : IFavCitiesServices
    {
        private DataServiceSoapClient dataService = new DataServiceSoapClient("DataServiceSoap", "http://localhost:9090/DataService.asmx");

        public bool AddFavCities(string token, FavCities favCities)
        {
            var userService = new UserService();
            var user = userService.Authenticate(token);
            if (user!=null && user.Id == favCities.UserId)
            {
                var cities = dataService.GetAllCities();
                if(cities.Any(c => c.Id == favCities.OriginCityId))
                {
                    dataService.AddFavCities(favCities);
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

    }
}