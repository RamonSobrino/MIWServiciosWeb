using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using PlanAdviser.CitiesService.DAO;
using PlanAdviser.CitiesService.DAO.Impl;

namespace PlanAdviser.CitiesService
{
    public class DAOFactory : IDisposable
    {
        private DataContext _context;

        public DAOFactory()
        {
            _context = new DataContext();
        }

        public ICityDAO CityDAO
        {
            get { return new CityDAO(_context); }
        }

        public IDistanceDAO DistanceDAO
        {
            get { return new DistanceDAO(_context); }
        }


        public void Dispose() { _context.Dispose(); }
    }
}