using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using PlanAdviser.CitiesService.Model;

namespace PlanAdviser.CitiesService.DAO.Impl
{
    public class CityDAO : GenericDAO<City>, ICityDAO
    {
        public CityDAO(DataContext context) : base(context)
        {
        }
    }
}