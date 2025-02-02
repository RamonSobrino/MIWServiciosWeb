﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WS.Recomendation.Data.DAO.Impl;
using WS.Recomendation.Data.Data;

namespace WS.Recomendation.Data.DAO
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

        public IUserDAO UserDAO
        {
            get { return new UserDAO(_context); }
        }

        public IFavCitiesDAO FavCitiesDAO
        {
            get { return new FavCitiesDAO(_context); }
        }

        public void Dispose() { _context.Dispose(); }
    }
}