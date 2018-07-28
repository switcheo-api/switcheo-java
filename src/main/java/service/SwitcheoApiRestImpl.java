package service;

import model.Offer;

import java.util.List;

import static service.SwitcheoApiServiceGenerator.executeSync;

public class SwitcheoApiRestImpl implements SwitcheoApi {

    private SwitcheoApiService switcheoApiService;

    @Override
    public void healthCheck() {
        executeSync(switcheoApiService.healthCheck());
    }

    @Override
    public List<Offer> getOffers(String symbol) {
        return executeSync(switcheoApiService.getOffers(symbol));
    }
}
