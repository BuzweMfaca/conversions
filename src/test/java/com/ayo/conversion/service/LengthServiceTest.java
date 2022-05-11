package com.ayo.conversion.service;

import com.ayo.conversion.service.impl.LengthServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LengthServiceTest {

    @InjectMocks
    LengthServiceImpl lengthService;

    @Test
    void shouldReturnMilesValueWhenGivenKilometersValue(){
        assertThat(lengthService.toImperial(42.2)).isEqualTo(26.23);
    }

    @Test
    void shouldReturnKilometersValueWhenGivenMilesValue(){
        assertThat(lengthService.toMetric(26.23)).isEqualTo(42.2);
    }

}
