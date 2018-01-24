package com.example.minhphuong.mock_unit.datasource;

import com.example.minhphuong.mock_unit.api.CharactersDataSource;
import com.example.minhphuong.mock_unit.model.CharactersResponseModel;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by minhphuong on 1/24/18.
 */

public class CharactersRemoteDataSource implements CharactersDataSource {
    private CharactersDataSource api;
    private final String URL = "http://swapi.co/api/";

    public CharactersRemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        this.api = retrofit.create(CharactersDataSource.class);
    }

    @Override
    public Observable<CharactersResponseModel> getCharacters() {
        return this.api.getCharacters();
    }
}

