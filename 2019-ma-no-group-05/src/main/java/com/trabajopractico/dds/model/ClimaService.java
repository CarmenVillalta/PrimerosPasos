package com.trabajopractico.dds.model;

/*import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;*/

import java.time.LocalDateTime;

public class ClimaService {
    private ClimaRepository climaRepository;

    public ClimaService(ClimaRepository climaRepository){
        this.climaRepository = climaRepository;
    }

    public double getTemperaturaFor(String ciudad, LocalDateTime hora) throws Exception {
        return climaRepository.getClimaFor(ciudad, hora);
    }
    public double getTemperaturaForTest(String ciudad, LocalDateTime hora)throws Exception {
        return 25.0;
    }
}
//private OWM ApiClima;
/*
    public ClimaService(){
        // declaring object of "OWM" class
        OWM owm = new OWM("e0992c9f74216ec87168d168a3cea744");
        ApiClima = owm;
    }
*/
/*
    public double obtenerTemperatura() throws APIException {

        // Obtiene la temperatura por el ID de buenos aires
        CurrentWeather cwd = ApiClima.currentWeatherByCityId(6559994);
        return (cwd.getMainData().getTemp()-273.15);
    }*/