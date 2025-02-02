﻿using Newtonsoft.Json;
using RestSharp;
using RestSharp.Deserializers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WS.Recomendation.Cities.Utils
{
    public class DynamicJsonDeserializer : IDeserializer
    {
        public string RootElement { get; set; }
        public string Namespace { get; set; }
        public string DateFormat { get; set; }
        public T Deserialize<T>(IRestResponse response)
        {
            return JsonConvert.DeserializeObject<dynamic>(response.Content);
        }
    }
}