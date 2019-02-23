using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace WS.Recomendation.Authentication.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private IUserService _userService;

        public UserController(IUserService userService)
        {
            _userService = userService;
        }

        // GET: api/User
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/User/5
        [HttpGet("{id}", Name = "Get")]
        public string Get(int id)
        {
            return "value";
        }

        // POST: User/login
        [HttpPost]
        [Route("login/")]
        public IActionResult Post(User user)
        {
            var transferir = new Token{  Name = user.Name,
                                    Password = user.Password,
                                    Time = TimeZone.CurrentTimeZone.ToLocalTime(DateTime.Now).AddMinutes(30) };

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
        [Route("register/")]
        public IActionResult PostReg(User user)
        {
            if (_userService.AddUser(user)) { 
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
            }else{
                return BadRequest();
            }
        }

        // PUT: api/User/5
        [HttpPut]
        public IActionResult Put( [FromBody] User value)
        {

            var authHeader = HttpContext.Request.Headers.FirstOrDefault(hed => hed.Key.Equals("Authorization")).Value;
            if (_userService.Authenticate(authHeader)!=default) {

               if(_userService.ModifyUser(authHeader, value))
                {
                    return Ok(authHeader);
                }
                else
                {
                    return BadRequest();
                }

            }
            else {
                return BadRequest();
            }
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
