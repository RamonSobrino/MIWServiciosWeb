using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using PlanAdviser.CitiesService.Model;

namespace PlanAdviser.CitiesService.DAO.Impl
{
    public class DistanceDAO : GenericDAO<Distance>, IDistanceDAO
    {
        public DistanceDAO(DataContext context) : base(context)
        {
        }
    }
}