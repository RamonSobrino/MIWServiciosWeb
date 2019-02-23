using Newtonsoft.Json;
using System;
using System.Collections.Generic;

namespace WS.Recomendation.Authentication
{
    public class UserService : IUserService
    {
        private List<User> _users = new List<User>
        {
            new User { Name = "admin", Password = "admin"},
            new User { Name = "Ramon", Password = "1234"}
        };

        public User Authenticate(string token)
        {
            if (!String.IsNullOrEmpty(token))
            {
                Encripter encripter = new Encripter();

                var valor = encripter.Desencripta(token);
                var objeto = JsonConvert.DeserializeObject<Token>(valor);

                if(objeto.Time > DateTime.Now)
                {
                    if (UserExists(objeto.Name, objeto.Password))
                    {
                        return new User { Name = objeto.Name, Password = objeto.Password };
                    }
                    else
                    {
                        return default;
                    }
                }
                else
                {
                    return default;
                }
                
            }
            else
            {
                return default;
            }
        }

        public Boolean UserExists(string name, string password)
        {
            return _users.Exists(user => user.Name.Equals(name) && user.Password.Equals(password));
        }

        public Boolean AddUser(User user)
        {
            if (UserExists(user.Name, user.Password))
            {
                return false;
            }
            else
            {
                _users.Add(user);
                return true;
            }
        }

        public Boolean ModifyUser(string token, User userNuevo)
        {
            Encripter encripter = new Encripter();

            var valor = encripter.Desencripta(token);
            var objeto = JsonConvert.DeserializeObject<Token>(valor);

            var user =  _users.Find(us => us.Name.Equals(objeto.Name));
            if(user != default)
            {
                if (!_users.Exists(u => u.Name.Equals(userNuevo.Name))){
                    user.Name = userNuevo.Name;
                    user.Password = userNuevo.Password;
                    return true;
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