using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WS.Recomendation.Data.Data;
using WS.Recomendation.Data.Model;

namespace WS.Recomendation.Data.DAO.Impl
{
    public class DistanceDAO : GenericDAO<Distance>, IDistanceDAO
    {
        public DistanceDAO(DataContext context) : base(context)
        {
        }
    }
}