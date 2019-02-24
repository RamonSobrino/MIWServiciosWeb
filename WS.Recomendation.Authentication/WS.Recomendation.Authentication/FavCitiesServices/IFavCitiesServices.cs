using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WS.Recomendation.Authentication.ServiceData;

namespace WS.Recomendation.Authentication.FavCitiesServices
{
    public interface IFavCitiesServices
    {
        Boolean AddFavCities(string token, int city);
    }
}
