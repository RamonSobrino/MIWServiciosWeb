using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WS.Recomendation.Authentication
{
    public interface IUserService
    {
        User Authenticate(string token);
        Boolean UserExists(string name, string password);
        Boolean AddUser(User user);
        Boolean ModifyUser(string token, User userNuevo);
    }
}
