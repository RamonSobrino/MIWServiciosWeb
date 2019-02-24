using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WS.Recomendation.Data.Data;
using WS.Recomendation.Data.Model;

namespace WS.Recomendation.Data.DAO.Impl
{
    public class FavCitiesDAO : GenericDAO<FavCities>, IFavCitiesDAO
    {
        public FavCitiesDAO(DataContext context) : base(context)
        {
        }
    }
}