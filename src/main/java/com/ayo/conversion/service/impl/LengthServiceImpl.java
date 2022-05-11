package com.ayo.conversion.service.impl;

import com.ayo.conversion.service.ConversionInterface;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;


@Service
public class LengthServiceImpl implements ConversionInterface {

    @Override
    public double toImperial(double kilometers) {
        return DoubleRounder.round(kilometers / 1.609, 2);
    }

    @Override
    public double toMetric(double  miles) {
        return DoubleRounder.round(miles * 1.609,2);
    }
}
