using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace PlanAdviser.CitiesService.Model
{
    public class Distance
    {
        [Key]
        [Column(Order = 1)]
        public int OriginCityId {get; set;}
        [Key]
        [Column(Order = 2)]
        public int DestinationCityId { get; set; }
        public int DistanceInKm { get; set; }
    }
}