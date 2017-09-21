package com.dotalist.dalviik.dota2heroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dotalist.dalviik.dota2heroes.adapters.ListaItemsAdapter;
import com.dotalist.dalviik.dota2heroes.itemapi.ItemapiService;
import com.dotalist.dalviik.dota2heroes.model.Item;
import com.dotalist.dalviik.dota2heroes.model.ItemRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemsActivity extends AppCompatActivity {
    private static final String TAG = "ITEM";
    private RecyclerView recyclerViewItem;
    private ListaItemsAdapter listaItemsAdapter;


    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        recyclerViewItem = (RecyclerView) findViewById(R.id.itemRecyclerView);
        listaItemsAdapter = new ListaItemsAdapter(this);
        recyclerViewItem.setAdapter(listaItemsAdapter);
        recyclerViewItem.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerViewItem.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kronusme/dota2-api/master/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();
    }

    private void obtenerDatos() {

        ItemapiService service = retrofit.create(ItemapiService.class);
        Call<ItemRespuesta> itemRespuestaCall = service.obtenerListaItem();

        itemRespuestaCall.enqueue(new Callback<ItemRespuesta>() {
            @Override
            public void onResponse(Call<ItemRespuesta> call, Response<ItemRespuesta> response) {
                if (response.isSuccessful()) {
                    ItemRespuesta itemRespuesta = response.body();
                    ArrayList<Item> listaItem = itemRespuesta.getItems();

                    listaItemsAdapter.adicionarItem(listaItem);

                } else {
                    Log.e(TAG, "onResponse ASD: " + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<ItemRespuesta> call, Throwable t) {

            }
        });


    }
}
