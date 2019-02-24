using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;
using WS.Recomendation.Authentication.FavCitiesServices;
using WS.Recomendation.Authentication.Models;
using WS.Recomendation.Authentication.ServiceData;
using WS.Recomendation.Authentication.UserServices;

namespace WS.Recomendation.Authentication.Controllers
{
    public class UserController : ApiController
    {
        
        // GET: api/User
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/User/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: User/login
        [HttpPost]
        [Route("User/login/")]
        public IHttpActionResult Post(User user)
        {
            IUserService _userService = new UserService();
            var transferir = new Token
            {
                Name = user.Name,
                Password = user.Password,
                Time = TimeZone.CurrentTimeZone.ToLocalTime(DateTime.Now).AddMinutes(30)
            };

            String resultado = JsonConvert.SerializeObject(transferir);
            Encripter encripter = new Encripter();
            String token = encripter.Encripta(resultado);
            if (_userService.UserExists(user.Name, user.Password))
            {
                return Ok(token);
            }
            else
            {
                return BadRequest();
            }
        }


        // POST: User/login
        [HttpPost]
        [Route("User/register/")]
        public IHttpActionResult PostRegister(User user)
        {
            IUserService _userService = new UserService();
            if (_userService.AddUser(user))
            {
                var transferir = new Token
                {
                    Name = user.Name,
                    Password = user.Password,
                    Time = TimeZone.CurrentTimeZone.ToLocalTime(DateTime.Now).AddMinutes(30)
                };
                String resultado = JsonConvert.SerializeObject(transferir);
                Encripter encripter = new Encripter();
                String token = encripter.Encripta(resultado);
                return Ok(token);
            }
            else
            {
                return BadRequest();
            }
        }


        // POST: User/login
        [HttpPost]
        [Route("FavCities/")]
        public IHttpActionResult PostFavCities([FromUri]Int32 ciudad)
        {
            var  favCitiesService = new FavCitiesService();
            var authHeader = HttpContext.Current.Request.Headers.Get("Authorization");
            if (favCitiesService.AddFavCities(authHeader, ciudad))
            {
                return Ok(authHeader);
            }
            else
            {
                return BadRequest();
            }
        }

        // PUT: api/User/5
        [HttpPut]
        [Route("User/")]
        public IHttpActionResult Put([FromBody] User value)
        {
            IUserService _userService = new UserService();
            var authHeader = HttpContext.Current.Request.Headers.Get("Authorization");
            if (_userService.Authenticate(authHeader) != null)
            {

                if (_userService.ModifyUser(authHeader, value))
                {
                    return Ok(authHeader);
                }
                else
                {
                    return BadRequest();
                }

            }
            else
            {
                return BadRequest();
            }
        }


        // DELETE: api/User/5
        public void Delete(int id)
        {
        }
    }
}
