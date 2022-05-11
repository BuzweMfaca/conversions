package com.ayo.conversion.service;

import com.ayo.conversion.service.impl.VolumeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class VolumeServiceTest {

    @InjectMocks
    VolumeServiceImpl volumeService;

    @Test
    void shouldReturnGallonsValueWhenGivenLitersValue(){
        assertThat(volumeService.toImperial(10)).isEqualTo(2.2);
    }

    @Test
    void shouldReturnLitersValueWhenGivenGallonsValue(){
        assertThat(volumeService.toMetric(2.2)).isEqualTo(10);
    }
}
