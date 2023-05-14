package com.dataportfolio.labor.service;

import com.dataportfolio.labor.component.BureauLaborStatisticsComponent;
import com.dataportfolio.labor.domain.interfaces.ILaborService;
import com.dataportfolio.labor.domain.models.TimeSeriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaborServiceImpl implements ILaborService {

    @Autowired
    private BureauLaborStatisticsComponent blsComponent;

    public TimeSeriesResponse getUnemploymentRates() {
        return blsComponent.getUnemploymentRates();
    }

    public TimeSeriesResponse getConsumePriceIndices() {
        return blsComponent.getConsumePriceIndices();
    }

}
