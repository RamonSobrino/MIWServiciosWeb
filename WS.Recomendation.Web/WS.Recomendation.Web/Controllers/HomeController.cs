using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WS.Recomendation.Web.Service;

namespace WS.Recomendation.Web.Controllers
{
    public class HomeController : Controller
    {
        private CitiesService service = new CitiesService();
        public ActionResult Index()
        {
            ViewBag.Cities = service.GetCities();
            ViewBag.Types = service.GetTypes();
            return View();
        }

        public ActionResult Login()
        {
            return View("Login");
        }

        public ActionResult Register()
        {
            return View("Register");
        }
        public ActionResult Favoritos()
        {
            var pedro = Session["Token"];
            Session["Token"] = pedro;
            ViewBag.Cities = service.GetCities();
            return View("Favoritos");
        }

        public ActionResult CerrarSesion()
        {
            Session["Token"] = null;
            ViewBag.Cities = service.GetCities();
            ViewBag.Types = service.GetTypes();

            return View("Index");
        }


        [HttpPost]
        public ActionResult Search(string cityId, string[] placeType)
        {
            ViewBag.result = service.GetResult(cityId, placeType[0]);
            return View("Result");
        }



        [HttpPost]
        public ActionResult PostLogin(string name, string password)
        {
            var respuesta = service.PostLogin(name,password);
            ViewBag.Cities = service.GetCities();
            ViewBag.Types = service.GetTypes();
            if (respuesta != null)
            {
                Session["Token"] = respuesta.Token;
                Session["Name"] = respuesta.Name;

            }
            return View("Index");
        }


        [HttpPost]
        public ActionResult PostRegister(string name, string password)
        {
            var respuesta = service.PostRegister(name, password);
            ViewBag.Cities = service.GetCities();
            ViewBag.Types = service.GetTypes();
            
            return View("Index");
        }

        [HttpPost]
        public ActionResult PostFavoritos(string cityId)
        {
            var token = Session["Token"] ;
            ViewBag.Token = service.PostFavoritos(cityId,(String) token);
            ViewBag.Cities = service.GetCities();
            ViewBag.Types = service.GetTypes();
            return View("Index");
        }

    }
}