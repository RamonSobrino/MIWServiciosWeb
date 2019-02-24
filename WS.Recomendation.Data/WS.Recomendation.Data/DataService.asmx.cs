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


        [WebMethod]
        public User[] GetAllUsers()
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.UserDAO.All().ToArray();
            }
        }

        [WebMethod]
        public FavCities[] GetAllFavCities()
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.FavCitiesDAO.All().ToArray();
            }
        }


        [WebMethod]
        public Boolean ExistUser(string name, string password)
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.UserDAO.All().Any(user => (user.Name.Equals(name)&&user.Password.Equals(password)));
            }
        }

        [WebMethod]
        public void AddUser(User user)
        {
            using (DAOFactory factory = new DAOFactory())
            {
                factory.UserDAO.Add(user);
            }
        }

        [WebMethod]
        public void AddFavCities(FavCities favCities)
        {
            using (DAOFactory factory = new DAOFactory())
            {
                factory.FavCitiesDAO.Add(favCities);
            }
        }

        [WebMethod]
        public Boolean UpdateUser(User user)
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.UserDAO.Update(user);
            }
        }

        [WebMethod]
        public User GetUserByName(string name)
        {
            using (DAOFactory factory = new DAOFactory())
            {
                return factory.UserDAO.All().First(user => (user.Name.Equals(name)));
            }
        }
    }
}
