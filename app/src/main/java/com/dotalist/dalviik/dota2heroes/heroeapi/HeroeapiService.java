package com.dotalist.dalviik.dota2heroes.heroeapi;

import com.dotalist.dalviik.dota2heroes.model.HeroeRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroeapiService {
    @GET("heroes.json")
    Call<HeroeRespuesta> obtenerListaHeroe();
}
