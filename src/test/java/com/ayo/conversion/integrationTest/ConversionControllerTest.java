package com.ayo.conversion.integrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConversionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void shouldConvertAreaImperialToMetricWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/area/metric/100",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("40.47");

    }

    @Test
    void shouldConvertAreaMetricToImperialWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/area/imperial/40.4694",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("100.0");

    }

    @Test
    void shouldConvertLengthImperialToMetricWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/length/metric/26.23",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("42.2");

    }

    @Test
    void shouldConvertLengthMetricToImperialWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/length/imperial/42.2",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("26.23");

    }

    @Test
    void shouldConvertMassImperialToMetricWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/mass/metric/450",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("204.08");

    }

    @Test
    void shouldConvertMassMetricToImperialWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/mass/imperial/204.08",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("450.0");

    }

    @Test
    void shouldConvertTemperatureImperialToMetricWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/temperature/metric/32",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("0.0");

    }

    @Test
    void shouldConvertTemperatureMetricToImperialWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/temperature/imperial/0",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("32.0");

    }

    @Test
    void shouldConvertVolumeImperialToMetricWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/volume/metric/2.2",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("10.0");

    }

    @Test
    void shouldConvertVolumeMetricToImperialWhenGivenCorrectParameters(){

        String result = testRestTemplate.getForObject(
                "http://localhost:"+ port + "/api/conversion/volume/imperial/10",String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("2.2");

    }


    @Test
    void shouldReturnNotFoundWhenGivenInvalidPath(){

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                "http://localhost:"+ port + "/api/conversion/volume/imperial/",String.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(responseEntity.getBody()).contains("Not Found");

    }


    @Test
    void shouldReturnErrorWhenGivenInvalidSystem(){

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                "http://localhost:"+ port + "/api/conversion/volume/test/10",String.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    }

    @Test
    void shouldReturnErrorWhenGivenInvalidMeasurement(){

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                "http://localhost:"+ port + "/api/conversion/java/imperial/10",String.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    }






}
