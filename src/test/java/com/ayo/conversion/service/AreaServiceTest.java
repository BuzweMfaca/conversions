package com.ayo.conversion.service;


import com.ayo.conversion.service.impl.AreaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AreaServiceTest {

    @InjectMocks
    private AreaServiceImpl areaService;

    @Test
    void shouldReturnHectareValueWhenGivenAcreValue(){
        assertThat(areaService.toImperial(40.47)).isEqualTo(100);
    }

    @Test
    void shouldReturnAcreValueWhenGivenHectareValue(){
        assertThat(areaService.toMetric(100)).isEqualTo(40.47);
    }

}
