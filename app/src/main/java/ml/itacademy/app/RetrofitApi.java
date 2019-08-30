package ml.itacademy.app;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import ml.itacademy.app.services.ItemService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    private static RetrofitApi instance;
    public static final String BASE_URL = "https://api.mercadolibre.com/";

    private ItemService itemsService;

    public static RetrofitApi getInstance() {
        if (instance == null) {
            instance = new RetrofitApi();
        }

        return instance;
    }

    private RetrofitApi() {
       final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

        OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build();

        itemsService = retrofit.create(ItemService.class);
    }

    public ItemService getItemsService() {
        return itemsService;
    }
}
