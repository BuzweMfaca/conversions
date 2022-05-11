package com.ayo.conversion.service;

import com.ayo.conversion.enumeration.Measurement;
import com.ayo.conversion.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ConversionService {

    @Autowired
    AreaServiceImpl areaService;

    @Autowired
    LengthServiceImpl lengthService;

    @Autowired
    MassServiceImpl massService;

    @Autowired
    TemperatureServiceImpl temperatureService;

    @Autowired
    VolumeServiceImpl volumeService;


    public ResponseEntity<String> convert(String measurement, String system, Double value) {

        if (measurement != null && system != null && value != null) {

            Double results;

            try {
                ConversionInterface conversion = getConversion(Measurement.valueOf(measurement.toUpperCase()));

                switch (system.toUpperCase()) {
                    case "IMPERIAL":
                        results = conversion.toImperial(value);
                        break;
                    case "METRIC":
                        results = conversion.toMetric(value);
                        break;
                    default:
                        throw new Exception("Invalid system, please use imperial or metric.");
                }

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(String.valueOf(results), HttpStatus.OK);

        }else{
            return new ResponseEntity<>("Missing Parameters", HttpStatus.BAD_REQUEST);
        }

    }

    private ConversionInterface getConversion(Measurement measurement) throws Exception {

        if (Measurement.AREA.equals(measurement)) {
            return areaService;
        } else if (Measurement.LENGTH.equals(measurement)) {
            return lengthService;
        } else if (Measurement.MASS.equals(measurement)) {
            return massService;
        } else if (Measurement.TEMPERATURE.equals(measurement)) {
            return temperatureService;
        } else if (Measurement.VOLUME.equals(measurement)) {
            return volumeService;
        } else {
            throw new Exception("Please use following measurements: Area, Length, Mass, Temperature and Volume");
        }

    }


}
