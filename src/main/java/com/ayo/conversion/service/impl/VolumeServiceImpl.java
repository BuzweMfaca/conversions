package com.ayo.conversion.service.impl;

import com.ayo.conversion.service.ConversionInterface;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;


@Service
public class VolumeServiceImpl implements ConversionInterface {

    @Override
    public double toImperial(double liters) {
        return DoubleRounder.round(liters / 4.546, 2);
    }

    @Override
    public double toMetric(double gallons) {
        return DoubleRounder.round(gallons * 4.546, 2);
    }
}
