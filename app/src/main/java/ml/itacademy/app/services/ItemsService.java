package ml.itacademy.app.services;

import ml.itacademy.app.dto.Items;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ItemsService {

    @GET("items/{itemId}")
    Call<Items> getItem(@Path(value = "itemId") String itemId);
}
