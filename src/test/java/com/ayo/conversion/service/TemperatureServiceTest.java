package com.ayo.conversion.service;

import com.ayo.conversion.service.impl.TemperatureServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TemperatureServiceTest {

    @InjectMocks
    TemperatureServiceImpl temperatureService;

    @Test
    void shouldReturnFahrenheitValueWhenGivenCelsiusValue(){
        assertThat(temperatureService.toImperial(0)).isEqualTo(32);
    }

    @Test
    void shouldReturnCelsiusValueWhenGivenFahrenheitValue(){
        assertThat(temperatureService.toMetric(32)).isEqualTo(0);
    }
}
