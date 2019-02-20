using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WS.Recomendation.Data.Model
{
    public class CityWeather
    {
        public double Temperature { get; set; }
        public double Humidity { get; set; }
        public string Description { get; set; }
    }
}