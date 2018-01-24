package com.example.minhphuong.mock_unit.api;

import com.example.minhphuong.mock_unit.model.CharactersResponseModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by minhphuong on 1/24/18.
 */

public interface CharactersDataSource {
    @GET("people/")
    Observable<CharactersResponseModel> getCharacters();
}
