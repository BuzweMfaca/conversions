package com.ayo.conversion.service;

import com.ayo.conversion.service.impl.MassServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MassServiceTest {

    @InjectMocks
    private MassServiceImpl massService;

    @Test
    void shouldReturnPoundsValueWhenGivenKilogramsValue(){
        assertThat(massService.toImperial(204.08)).isEqualTo(450);
    }

    @Test
    void shouldReturnKilogramsValueWhenGivenPounds(){
        assertThat(massService.toMetric(450)).isEqualTo(204.08);
    }

}
