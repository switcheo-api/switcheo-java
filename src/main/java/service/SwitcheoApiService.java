package service;

import model.Offer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface SwitcheoApiService {


    /*
    healthCheck
     */
    @GET("")
    Call<Void> healthCheck();


    /*
        Retrieves the best 70 offers (per side) on the offer book for the pair
     */
    @GET("/v2/offers")
    Call<List<Offer>> getOffers(@Query("pair") String paid);


}
