package com.trabajopractico.dds.model;

import java.time.LocalDateTime;

import org.junit.Test;

public class ClimaTest {

    /*@Test
    public void receiveTemperatureForALocationFromURL_withValidLocationID_receiveTemperature(){
        //Seteo el ID de la Provincia de la que quiero conocer la temperatura
        String LOCATION_ID = "6559994";
        //Construyo mi objeto ClimaURL con el ID recibido
        ClimaURL climaURL = new ClimaURL(LOCATION_ID);
        //Obtengo la temperatura desde el ClimaURL creado
        Object temperature = climaURL.getTemperature();

        System.out.println(temperature);
        assertNotNull(temperature);
    }

    @Test
    public void receiveTemperatureForALocationFromURL_withInvalidLocationID_receveMinusOne(){
        String LOCATION_ID = "wrongID";
        ClimaURL climaURL = new ClimaURL(LOCATION_ID);
        Object temperature = climaURL.getTemperature();

        System.out.println(temperature);
        assertEquals(-1,temperature);
    }*/

	private ClimaService climaService;

    /*@Test
    public void getTemperartureFor_withValidLocationAndDate_receiveTemperature() throws Exception {
        climaService = Mockito.mock(ClimaService.class);
        when(climaService.getTemperaturaFor("Buenos Aires", LocalDateTime.now())).thenReturn(15);

        //Crear codigo que llame al service para testear el mockeo.
    }*/

    @Test
    public void getTemperatureFor () throws Exception {
        ApiClima apiClima= new ApiClima();
        apiClima.setAPI_KEY("06c148b53ea6ac6798311ab18241b581");
        apiClima.setLOCATION_ID("Buenos Aires");
        String urlString =
                "http://api.openweathermap.org/data/2.5/weather?q=";

        apiClima.setUrlString(urlString);
        ClimaRepository climaRepository = new ClimaRepository();
        climaRepository.addApi(apiClima);
        ClimaService climaService = new ClimaService(climaRepository);
        LocalDateTime hora = LocalDateTime.now();

        System.out.println("La temperatura es " + climaService.getTemperaturaFor("Buenos Aires", hora));

    }
}
