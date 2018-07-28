package service;

import model.Offer;

import java.util.List;

public interface SwitcheoApi {

    void healthCheck();

    List<Offer> getOffers(String symbol);


}
