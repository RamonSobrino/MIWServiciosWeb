using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace WS.Recomendation.Data.Model
{
    public class FavCities
    {
        [Key]
        [Column(Order = 1)]
        public int OriginCityId { get; set; }
        [Key]
        [Column(Order = 2)]
        public int UserId { get; set; }
    }
}