package com.dataportfolio.labor.controller;

import com.dataportfolio.labor.domain.interfaces.ILaborService;
import com.dataportfolio.labor.domain.models.TimeSeriesResponse;
import com.dataportfolio.labor.error.TooManyRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/labor/rates")
public class LaborController {

    private final ILaborService laborService;

    public LaborController(ILaborService laborService) {
        this.laborService = laborService;
    }

    @GetMapping("/unemployment")
    public TimeSeriesResponse getUnemploymentRates() {
        TimeSeriesResponse response = laborService.getUnemploymentRates();
        processError(response);
        return response;

    }

    @GetMapping("/inflation")
    public TimeSeriesResponse getInflationRate() {
        TimeSeriesResponse response =  laborService.getConsumePriceIndices();
        processError(response);
        return response;
    }

    private void processError(TimeSeriesResponse response) {
        if (response.getStatus().equals("REQUEST_NOT_PROCESSED")) {
            throw new TooManyRequestException();
        }
    }
}
