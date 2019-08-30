package ml.itacademy.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;
import ml.itacademy.app.adapter.ItemsAdapter;
import ml.itacademy.app.dto.Item;
import ml.itacademy.app.services.ItemService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadRecycler();
    }

    private void loadRecycler(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


        final ArrayList<Item> itemList = new ArrayList<Item>() {{
            add(new Item("https://mla-s1-p.mlstatic.com/890907-MLA31286758621_062019-I.jpg",
                "Gabinete Pc Gamer Sentey X10 Rgb Acrilic Usb 3.0 Sin Fuente"));
            add(new Item("https://mla-s2-p.mlstatic.com/754401-MLA31592574795_072019-I.jpg",
                "Lego Star Wars - Microfighter: Halcón Milenario (75193)"));
            add(new Item("https://mla-s2-p.mlstatic.com/801537-MLA31563320428_072019-I.jpg",
                "Celular Kodak Smartway L1 Doble Cámara 8gb Huella 12 Ctas"));
        }};

        final ItemsAdapter itemsAdapter = new ItemsAdapter(itemList);
        recyclerView.setAdapter(itemsAdapter);

        final ItemService itemsService = RetrofitApi.getInstance().getItemsService();
        final Call<Item> itemCall = itemsService.getItem("MLA31286758621");
        itemCall.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(final Call<Item> call, final Response<Item> response) {
            }

            @Override
            public void onFailure(final Call<Item> call, final Throwable t) {
            }
        });
    }
}
