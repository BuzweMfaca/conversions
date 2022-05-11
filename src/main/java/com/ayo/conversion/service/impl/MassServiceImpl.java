package com.ayo.conversion.service.impl;

import com.ayo.conversion.service.ConversionInterface;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;


@Service
public class MassServiceImpl implements ConversionInterface {

    @Override
    public double toImperial(double kilograms) {
        return DoubleRounder.round(kilograms * 2.205,2);
    }

    @Override
    public double toMetric(double pounds) {
        return DoubleRounder.round(pounds / 2.205, 2);
    }
}
