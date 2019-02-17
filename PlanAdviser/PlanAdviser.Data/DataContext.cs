using PlanAdviser.CitiesService.Model;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace PlanAdviser.CitiesService
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