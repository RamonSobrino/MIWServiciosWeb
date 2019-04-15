package com.example.recomendations.activities

import com.example.recomendations.model.CityModel
import com.example.recomendations.model.PlaceModel
import com.example.recomendations.model.WeatherModel

val cities_static = listOf(
    CityModel(
        2, "A Coruña",
        43.3712, -8.3959,
        listOf(
            PlaceModel(
                "Museo Domus",
                "Rúa Ángel Rebollo, 91, A Coruña",
                4.3,43.37757, -8.4065999
            ),
            PlaceModel(
                "Coruña Fine Arts Museum",
                "Rúa Zalaeta, 2, A Coruña",
                4.4, 43.3727413, -8.4000629
            ),
            PlaceModel(
                "Casa Museo de Emilia Pardo Bazán",
                "Rúa Tabernas, 11, A Coruña",
                4.4, 43.36942200000001, -8.394506999999999
            ),
            PlaceModel(
                "Casa Museo Picasso",
                "Rúa Payo Gómez, 14, A Coruña",
                4.1, 43.3672751, -8.407130300000002
            ),
            PlaceModel(
                "Casa Museo María Pita",
                "Rúa de Herrerías, 28, A Coruña",
                4.0, 43.3710648, -8.392365700000001
            ),
            PlaceModel(
                "Museo de Arte Sacro de la Colegiata",
                "Rúa Porta de Aires, 23, A Coruña",
                3.9, 43.3709582, -8.3926406
            ),
            PlaceModel(
                "Bomoble",
                "Rúa Nosa Señora do Rosario, 11, A Coruña",
                4.9, 43.37100299999999, -8.394286
            ),
            PlaceModel(
                "RAG",
                "Rúa Tabernas, 13, A Coruña",
                4.5, 43.36940860000001, -8.3944951
            ),
            PlaceModel(
                "Casa Museo Casares Quiroga",
                "Rúa Panaderas, 12, A Coruña",
                4.4, 43.373035, -8.397988499999999
            ),
            PlaceModel(
                "Casa de Rosalía de Castro",
                "Rúa Príncipe, 3, A Coruña",
                3.3, 43.36956730000001, -8.392898400000002
            ),
            PlaceModel(
                "Museo Arqueolóxico e Histórico Castelo de Santo Antón",
                "Paseo Marítimo Alcalde Francisco Vázquez, 2, A Coruña",
                4.5, 43.3656987, -8.3877777
            ),
            PlaceModel(
                "Museo Histórico Militar da Coruña",
                "Praza Carlos I, s/n, A Coruña",
                4.6, 43.369201, -8.3900785
            ),
            PlaceModel(
                "Cidade Vella",
                "Calle Ángeles, 2, A Coruña",
                4.3, 43.3702824, -8.394964499999999
            ),
            PlaceModel(
                "FLO",
                "Praza da Constitución, 5, A Coruña",
                4.6, 43.36930159999999, -8.3933613
            ),
            PlaceModel(
                "Palacio de Capitanía General",
                "Praza da Constitución, A Coruña",
                4.8, 43.36926429999999, -8.3932007
            ),
            PlaceModel(
                "Gapitanía Gral",
                "la Cruz u, Praza Xeneral Cánovas Lacruz, A Coruña",
                0.0, 43.3690075, -8.3934561
            ),
            PlaceModel(
                "Monumento a Curros Enríquez",
                "Avenida Xardíns de Méndez Núñez, 2172, A Coruña",
                4.5, 43.3686843, -8.400663899999998
            ),
            PlaceModel(
                "Palmeral y adoquinado",
                "A Coruña",
                5.0, 43.3678478, -8.402165799999999
            ),
            PlaceModel(
                "Corvid Nest",
                "Rúa Ángel Rebollo, 12, A Coruña",
                0.0, 43.3766243, -8.400702
            ),
            PlaceModel(
                "Jano Muñoz",
                "Rúa Ángel Rebollo, 81, A Coruña",
                5.0, 43.3771339, -8.4043524
            )
        ),
        listOf(
            WeatherModel(10.25, 95, "Rain")
            ,WeatherModel(12.74, 61, "Rain")
            ,WeatherModel(11.0, 97, "Rain")
            ,WeatherModel(9.18, 100, "Rain")
            ,WeatherModel(11.16, 91, "Rain")
        )
    ),
    CityModel(
        3, "Málaga",
        36.7213, -4.4217,
        listOf(
            PlaceModel(
                "Picasso Museum Málaga",
                "Palacio de Buenavista, Calle San Agustín, 8, Málaga",
                4.3, 36.7217363, -4.4184291
            ),
            PlaceModel(
                "CAC Malaga",
                "Calle Alemania, S/N",
                4.5, 36.71404400000001, -4.425481
            ),
            PlaceModel(
                "Museo Casa Natal de Picasso",
                "Plaza de la Merced, 15, Málaga",
                3.9, 36.724046, -4.417574999999999
            ),
            PlaceModel(
                "Malaga Wine Museum",
                "Plaza de los Viñeros, 1, Málaga",
                4.0, 36.72329109999999, -4.4243784
            ),
            PlaceModel(
                "Museo del Patrimonio Municipal",
                "Paseo Reding, 1, Málaga",
                4.4, 36.7211581, -4.4125697
            ),
            PlaceModel(
                "Museo Unicaja de Artes y Costumbres Populares",
                "Plaza Enrique García-Herrera, 1, Málaga",
                4.4, 36.7200111, -4.424640699999999
            ),
            PlaceModel(
                "Classroom of the Sea Museum Alborania",
                "Palmeral de las Sorpresas, Muelle 2,, Málaga",
                4.1, 36.7182438, -4.4162083
            ),
            PlaceModel(
                "Museum of Glass and Crystal",
                "Plazuela Santísimo Cristo de la Sangre, 2, Málaga",
                4.5, 36.72587109999999, -4.421297099999999
            ),
            PlaceModel(
                "Galería Benedito",
                "Calle Niño de Guevara, 2, Málaga",
                3.7, 36.7222582, -4.4191604
            ),
            PlaceModel(
                "Interactive Music Museum",
                "Calle Beatas, 15, Málaga",
                4.4, 36.7233145, -4.4197763
            ),
            PlaceModel(
                "Real Academia de Bellas Artes de San Telmo",
                "Plaza de la Aduana, S/N, Málaga",
                3.8, 36.71986639999999, -4.417449899999999
            ),
            PlaceModel(
                "Principia Science Center",
                "Avenida de Luis Buñuel, 6, Málaga",
                4.6, 36.733282, -4.427927
            ),
            PlaceModel(
                "Peña Juan Breva",
                "Calle Ramón Franquelo, 4, Málaga",
                4.3, 36.7230679, -4.419242100000001
            ),
            PlaceModel(
                "Carmen Thyssen Museum",
                "Calle Compañía, 10, Málaga",
                4.4, 36.7214101, -4.422992499999999
            ),
            PlaceModel(
                "X Games Malaga",
                "Calle Nueva, 13, Málaga",
                5.0, 36.7200159, -4.4227527
            ),
            PlaceModel(
                "Cathedral of Malaga",
                "Calle Císter, s/n, Málaga",
                4.6, 36.72010109999999, -4.4195508
            ),
            PlaceModel(
                "Cofrade Art Museum - Easter",
                "Calle Muro de San Julián, 2, Málaga",
                3.7, 36.7235297, -4.4224007
            ),
            PlaceModel(
                "Fundación Museo Picasso Málaga Legado Paúl Christine Y Bernard Ruiz Picasso",
                "Calle San Agustín, 8, Málaga",
                4.4, 36.7216857, -4.4184548
            ),
            PlaceModel(
                "Malaga Museum",
                "Plaza de la Aduana, Málaga",
                4.6, 36.71994189999999, -4.4171606
            ),
            PlaceModel(
                "Parque",
                "Paseo del Parque, 67, Málaga",
                5.0, 36.7195135, -4.415928099999999
            )
        ),
        listOf(
            WeatherModel(16.76,96, "Clear")
            ,WeatherModel(15.39,99, "Clouds")
            ,WeatherModel(15.0,100, "Rain")
            ,WeatherModel(13.83,100, "Clouds")
            ,WeatherModel(14.01,100, "Clouds")
        )
    ),
    CityModel(
        1, "Oviedo",
        43.36029, -5.84476,
        listOf(
            PlaceModel(
                "Suchi Go",
                "Calle de Campomanes, 6, 33008 Oviedo, Asturias",
                4.2, 43.359003, -5.845461
            ),
            PlaceModel(
                "Catedral",
                "Plaza Alfonso II el Casto, s/n, 33003 Oviedo, Asturias",
                4.5, 43.36267, -5.84326
            ),
            PlaceModel(
                "Estatua de mafalda",
                "Calle Uria, s/n, 33004 Oviedo, Asturias",
                4.4, 43.362401, -5.850512
            ),
            PlaceModel(
                "Modoo",
                "Calle Arturo Álvarez Buylla, 5, 33005 Oviedo, Asturias",
                3.1, 43.358311, -5.860737
            ),
            PlaceModel(
                "El regreso de Williams B. Arrensberg",
                "Calle Eusebio Gonzalez Abascal, 11, 33003 Oviedo, Asturias",
                4.2, 43.362269, -5.845746
            )
        ),
        listOf(
            WeatherModel(15.0,80, "Rain")
            ,WeatherModel(13.83,100, "Clouds")
            ,WeatherModel(15.39,99, "Clouds")
            ,WeatherModel(15.0,100, "Rain")
            ,WeatherModel(16.76,96, "Clear")
        )
    )



)

