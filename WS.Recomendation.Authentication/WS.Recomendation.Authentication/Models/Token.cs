using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WS.Recomendation.Authentication.Models
{
    public class Token
    {
        public string Name { get; set; }
        public string Password { get; set; }
        public DateTime Time { get; set; }
    }
}