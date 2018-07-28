package service;

import java.io.IOException;
import constants.SwitcheoApiConstants;
import exceptions.SwitcheoApiError;
import exceptions.SwitcheoApiException;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import security.AuthenticationInterceptor;
public class SwitcheoApiServiceGenerator {

    static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(SwitcheoApiConstants.API_BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    /*
    Creating a service class
     */
    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret){
        if (!StringUtils.isEmpty(apiKey) && !StringUtils.isEmpty(secret)) {
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret);
            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);
                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }
        return retrofit.create(serviceClass);
    }

    /*
    Executing a call in sync
     */

    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                SwitcheoApiError apiError = getSwitcheoApiError(response);
                throw new SwitcheoApiException(apiError);
            }
        } catch (IOException e) {
            throw new SwitcheoApiException(e);
        }
    }

    private static <T> SwitcheoApiError getSwitcheoApiError(Response<T> response) {
        return new SwitcheoApiError(200, "Abc");
    }
}
