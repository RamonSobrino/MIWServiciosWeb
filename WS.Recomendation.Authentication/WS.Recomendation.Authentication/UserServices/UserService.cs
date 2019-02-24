using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Newtonsoft.Json;
using WS.Recomendation.Authentication.Models;
using WS.Recomendation.Authentication.ServiceData;

namespace WS.Recomendation.Authentication.UserServices
{
    public class UserService :IUserService
    {
        public UserService() { }

        private DataServiceSoapClient dataService = new DataServiceSoapClient("DataServiceSoap", "http://localhost:9090/DataService.asmx");


        public User Authenticate(string token)
        {
            if (!String.IsNullOrEmpty(token))
            {
                Encripter encripter = new Encripter();

                var valor = encripter.Desencripta(token);
                var objeto = JsonConvert.DeserializeObject<Token>(valor);

                if (objeto.Time > DateTime.Now)
                {
                    if (UserExists(objeto.Name, objeto.Password))
                    {

                        return this.dataService.GetUserByName(objeto.Name);
                    }
                    else
                    {
                        return null;
                    }
                }
                else
                {
                    return null;
                }

            }
            else
            {
                return null;
            }
        }

        public Boolean UserExists(string name, string password)
        {
            return this.dataService.ExistUser(name, password);
        }

        public Boolean AddUser(User user)
        {
            if (UserExists(user.Name, user.Password))
            {
                return false;
            }
            else
            {
                this.dataService.AddUser(user);
                return true;
            }
        }

        public Boolean ModifyUser(string token, User userNuevo)
        {
            Encripter encripter = new Encripter();

            var valor = encripter.Desencripta(token);
            var objeto = JsonConvert.DeserializeObject<Token>(valor);

            var user = this.dataService.GetUserByName(objeto.Name);
            if (user != null)
            {
                if (!this.dataService.GetAllUsers().Any(u => u.Name.Equals(userNuevo.Name)))
                {
                    user.Name = userNuevo.Name;
                    user.Password = userNuevo.Password;
                    return this.dataService.UpdateUser(user);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
    }
}