package ml.itacademy.app.services;

import ml.itacademy.app.dto.Item;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ItemService {

    @GET("items/{itemId}")
    Call<Item> getItem(@Path(value = "itemId") String itemId);
}
