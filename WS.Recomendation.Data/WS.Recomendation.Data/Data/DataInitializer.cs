using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using WS.Recomendation.Data.Model;

namespace WS.Recomendation.Data.Data
{
    public class DataInitializer : DropCreateDatabaseAlways<DataContext>
    {
        protected override void Seed(DataContext context)
        {
            base.Seed(context);

            string[] cities = Resources.cities_array.Split(',');
            foreach (string cityName in cities)
            {
                context.Cities.Add(new City() { Name = cityName });
            }
            var matrix = new int[47, 47];
            var rows = Resources.distance_matrix.Split('\n');
            for (int i = 0; i < rows.Count(); i++)
            {
                var columns = rows[i].Split(',');
                for (int j = 0; j < columns.Count(); j++)
                {
                    matrix[i, j] = int.Parse(columns[j]);
                    context.DistancesInKm.Add(new Distance() { OriginCityId = i, DestinationCityId = j, DistanceInKm = int.Parse(columns[j]) });
                }
            }
            context.SaveChanges();
        }
    }
}