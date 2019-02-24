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
                ViewBag.token = respuesta.Token;
                ViewBag.name = respuesta.Name;
            }

            return View("Index");
        }

    }
}