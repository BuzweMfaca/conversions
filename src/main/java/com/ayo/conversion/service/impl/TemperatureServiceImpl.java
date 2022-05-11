package com.ayo.conversion.service.impl;

import com.ayo.conversion.service.ConversionInterface;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;

@Service
public class TemperatureServiceImpl implements ConversionInterface {

    @Override
    public double toImperial(double celsius) {
        return DoubleRounder.round((celsius * (9/5)) + 32, 2);
    }

    @Override
    public double toMetric(double fahrenheit) {
        return DoubleRounder.round((fahrenheit - 32) * (9/5), 2) ;
    }
}
