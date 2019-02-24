# MIWServiciosWeb
## Servicios
### DataService
* Servicio de datos que se conecta con la base de datos
* URL: http://156.35.98.19:9091/WS.Recomendation.Data/DataService.asmx

### CitiesService
* Servicio para recuperar las ciudades cercanas a partir del id de una ciudad que se le proporciona
* URL: http://156.35.98.19:9092/WS.Recomendation.Cities/CitiesService.asmx

### PlacesService
* Servicio para recuperar los lugares recomendados en base a una localización geográfica y unos tipos establecidos
* URL: http://156.35.95.51:8080/WS.Recomendation.Places/soapws/v1

### AuthenticationService
* Servicio de autenticación de usuarios
* URL: POST http://156.35.98.19:9093/WS.Recomendation.Authentication/User/login
* URL: POST http://156.35.98.19:9093/WS.Recomendation.Authentication/User/register
