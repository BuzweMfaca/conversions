package com.ayo.conversion.service.impl;

import com.ayo.conversion.service.ConversionInterface;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;


@Service
public class AreaServiceImpl implements ConversionInterface {

    @Override
    public double toImperial(final double hectare) {
        return DoubleRounder.round(hectare * 2.471, 2);
    }

    @Override
    public double toMetric(final double acre) {
        return DoubleRounder.round(acre / 2.471, 2);
    }

}
