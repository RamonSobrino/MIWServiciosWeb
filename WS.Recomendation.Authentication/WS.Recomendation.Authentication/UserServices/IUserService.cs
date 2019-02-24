using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WS.Recomendation.Authentication.ServiceData;

namespace WS.Recomendation.Authentication.UserServices
{
    public interface IUserService
    {
        User Authenticate(string token);
        Boolean UserExists(string name, string password);
        Boolean AddUser(User user);
        Boolean ModifyUser(string token, User userNuevo);
    }
}
