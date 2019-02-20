using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using WS.Recomendation.Data.DAO;
using WS.Recomendation.Data.Model;

namespace WS.Recomendation.Data
{
    /// <summary>
    /// DataService
    /// </summary>
    [WebService(Namespace = "http://WS.Recomendation.Data.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    public class DataService : System.Web.Services.WebService
    {

        [WebMethod]
        public City[] GetAllCities()
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.CityDAO.All().ToArray();
            }
        }

        [WebMethod]
        public Distance[] GetDistancesByOriginCityId(int originCityId)
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.DistanceDAO.All()
                    .Where(distance => distance.OriginCityId == originCityId)
                    .ToArray();
            }
        }

        [WebMethod]
        public Distance[] GetDistancesByDestinationCityId(int originCityId)
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.DistanceDAO.All()
                    .Where(distance => distance.OriginCityId == originCityId)
                    .ToArray();
            }
        }

    }
}
