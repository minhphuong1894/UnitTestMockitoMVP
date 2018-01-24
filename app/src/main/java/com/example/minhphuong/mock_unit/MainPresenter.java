package com.example.minhphuong.mock_unit;

import android.support.annotation.NonNull;

import com.example.minhphuong.mock_unit.api.CharactersDataSource;
import com.example.minhphuong.mock_unit.model.CharactersResponseModel;

import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by minhphuong on 1/24/18.
 */

public class MainPresenter implements MainContract.Presenter {

    // the Retrofit description of the Star Wars characters endpoint.
    @NonNull
    private CharactersDataSource charactersDataSource;

    // the Scheduler on which our API request Observable will operate.
    @NonNull
    private Scheduler backgroundScheduler;

    // the Scheduler on which we want our observer to wait for the API request Observable callbacks.
    @NonNull
    private Scheduler mainScheduler;

    @NonNull
    private CompositeSubscription subscriptions;

    // any instance (can be a mock) that implements the view interface defined above.
    private MainContract.View view;

    public MainPresenter(
            @NonNull CharactersDataSource charactersDataSource,
            @NonNull Scheduler backgroundScheduler,
            @NonNull Scheduler mainScheduler,
            MainContract.View view) {
        this.charactersDataSource = charactersDataSource;
        this.backgroundScheduler = backgroundScheduler;
        this.mainScheduler = mainScheduler;
        this.view = view;
        subscriptions = new CompositeSubscription();
    }
    @Override
    public void loadData() {
        view.onFetchDataStarted();
        subscriptions.clear();

        Subscription subscription = charactersDataSource
                .getCharacters()
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .subscribe(new Observer<CharactersResponseModel>() {
                    @Override
                    public void onCompleted() {
                        view.onFetchDataCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onFetchDataError(e);
                    }

                    @Override
                    public void onNext(CharactersResponseModel rootModel) {
                        view.onFetchDataSuccess(rootModel);
                    }
                });

        subscriptions.add(subscription);
    }
    @Override
    public void subscribe() {
        loadData();
    }

    @Override
    public void unsubscribe() {
        subscriptions.clear();
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
