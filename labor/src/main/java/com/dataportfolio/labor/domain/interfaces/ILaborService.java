package com.dataportfolio.labor.domain.interfaces;

import com.dataportfolio.labor.domain.models.TimeSeriesResponse;

public interface ILaborService {

    public TimeSeriesResponse getUnemploymentRates();

    public TimeSeriesResponse getConsumePriceIndices();

}
