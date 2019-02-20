using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WS.Recomendation.Data.Model
{
    public class City
    {
        public int Id { get; set; }
        public string Name { get; set; }

        public double? Latitude { get; set; }

        public double? Longitude { get; set; }

        public CityWeather[] Weather5Days { get; set; }

        public City()
        {
            Weather5Days = new CityWeather[] { };
        }
    }
}