package com.example.qr;

import com.example.qr.Models.Search;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface PlaceHolderApi {

  @GET("search")
  Call<Search> searchItem(@QueryMap Map<String,String> params);

}
