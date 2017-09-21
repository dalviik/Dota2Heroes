package com.dotalist.dalviik.dota2heroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dotalist.dalviik.dota2heroes.adapters.ListaHeroesAdapter;
import com.dotalist.dalviik.dota2heroes.heroeapi.HeroeapiService;
import com.dotalist.dalviik.dota2heroes.model.Heroe;
import com.dotalist.dalviik.dota2heroes.model.HeroeRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesActivity extends AppCompatActivity {

    private static final String TAG = "HEROE";

    private RecyclerView recyclerViewHeroe;
    private ListaHeroesAdapter listaHeroesAdapter;

    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        recyclerViewHeroe = (RecyclerView) findViewById(R.id.heroesRecyclerView);
        listaHeroesAdapter = new ListaHeroesAdapter(this);
        recyclerViewHeroe.setAdapter(listaHeroesAdapter);
        recyclerViewHeroe.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerViewHeroe.setLayoutManager(layoutManager);


        retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kronusme/dota2-api/master/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();
    }
    private void obtenerDatos(){

        HeroeapiService service = retrofit.create(HeroeapiService.class);
        Call<HeroeRespuesta> heroeRespuestaCall = service.obtenerListaHeroe();

      heroeRespuestaCall.enqueue(new Callback<HeroeRespuesta>() {
          @Override
          public void onResponse(Call<HeroeRespuesta> call, Response<HeroeRespuesta> response) {
              if (response.isSuccessful()){
                  HeroeRespuesta heroeRespuesta= response.body();
                  ArrayList<Heroe> listaHeroe = heroeRespuesta.getHeroes();

                  listaHeroesAdapter.adicionarHeroe(listaHeroe);


              }else{
                  Log.e(TAG, "onResponse: "+response.errorBody());
              }
          }

          @Override
          public void onFailure(Call<HeroeRespuesta> call, Throwable t) {

          }
      });



    }
}
