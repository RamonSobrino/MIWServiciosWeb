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

        [HttpPost]
        public ActionResult Search(string cityId, string[] placeType)
        {
            ViewBag.result = service.GetResult(cityId, placeType[0]);
            return View("Result");
        }

    }
}