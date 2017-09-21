package com.dotalist.dalviik.dota2heroes.itemapi;

import com.dotalist.dalviik.dota2heroes.model.HeroeRespuesta;
import com.dotalist.dalviik.dota2heroes.model.ItemRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dxr on 20-09-17.
 */

public interface ItemapiService {
    @GET("items.json")
    Call<ItemRespuesta> obtenerListaItem();
}
