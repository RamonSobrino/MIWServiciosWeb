using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WS.Recomendation.Cities.WeatherService
{
    interface ICityWeatherService
    {
        dynamic GetForecastByCityName(string cityName, string countryCode = "es");
    }
}
