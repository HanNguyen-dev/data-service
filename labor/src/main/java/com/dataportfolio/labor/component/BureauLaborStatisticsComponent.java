package com.dataportfolio.labor.component;

import com.dataportfolio.labor.domain.models.TimeSeriesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BureauLaborStatisticsComponent {
    private final RestTemplate restTemplate;

    @Value("${urls.bureau-labor-statistics-api}")
    private String blsApiUrl;

    public BureauLaborStatisticsComponent() {
        restTemplate = new RestTemplate();
    }

    public TimeSeriesResponse getUnemploymentRates() {
        String url = blsApiUrl + "/LNS14000000";
        return restTemplate.getForEntity(url, TimeSeriesResponse.class).getBody();
    }

    public TimeSeriesResponse getConsumePriceIndices() {
        String url = blsApiUrl + "/CUUR0000SA0";
        return restTemplate.getForEntity(url, TimeSeriesResponse.class).getBody();
    }

}
