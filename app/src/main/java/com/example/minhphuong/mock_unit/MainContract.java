package com.example.minhphuong.mock_unit;

import com.example.minhphuong.mock_unit.model.CharactersResponseModel;

/**
 * Created by minhphuong on 1/24/18.
 */

public interface MainContract {
    interface View {
        // notify the view that a request is about to start. Useful for giving user a feedback like displaying a progress bar.
        void onFetchDataStarted();
        // notify the view that no more data will be returned.
        void onFetchDataCompleted();
        // return the requested data as its parameter, in the model type we have defined above.
        void onFetchDataSuccess(CharactersResponseModel charactersResponseModel);
        // an error has occurred during the request. Could be a connection failure, for example.
        void onFetchDataError(Throwable e);
    }

    interface Presenter {
        // will tell the presenter to start fetching data.
        void loadData();
        // notify the presenter that its view has become active. This can be used to trigger the API request.
        void subscribe();
        // notify the presenter that its view has become inactive. This can be used to cancel any previous request that hasn't returned yet.
        void unsubscribe();
        // notify the presenter that its view instance is about to be destroyed. In this tutorial the view will instantiate the presenter and they will maintain a reference to each other by private properties, so we should clear this reference on the presenter when the view is going through the onDestroy lifecycle otherwise this will lead to memory leaks.
        void onDestroy();

    }
}
