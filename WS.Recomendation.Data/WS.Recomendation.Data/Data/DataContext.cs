using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using WS.Recomendation.Data.Model;

namespace WS.Recomendation.Data.Data
{
    public class DataContext : DbContext
    {
        public DbSet<City> Cities { get; set; }
        public DbSet<Distance> DistancesInKm { get; set; }

        public DataContext()
        {
            Database.SetInitializer(new DataInitializer());
        }
    }
}