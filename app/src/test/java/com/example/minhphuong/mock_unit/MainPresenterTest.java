package com.example.minhphuong.mock_unit;

import com.example.minhphuong.mock_unit.api.CharactersDataSource;
import com.example.minhphuong.mock_unit.model.CharactersResponseModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by minhphuong on 1/24/18.
 */

public class MainPresenterTest {

    // this unit test here focus 2 test cases :
    // 1. Given the presenter has requested data and its data source has returned the characters data successfully,
    // I want to verify if the view receives it.

    // 2. e presenter has requested data and somehow the data source has returned error,
    // I want to verify if the view receives the proper feedback.

    // The “@Mock” annotation is from the Mockito dependency we have declared at our build.gradle,
    // and that means the library will be responsible to create a mock instance.
    @Mock
    private CharactersDataSource charactersDataSource;

    @Mock
    private MainContract.View view;

    //To make sure a new mock is created for each new test and therefore all tests are independent,
    // we will initialize the mocks at the “@Before” step of this test class.
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fetchValidDataShouldLoadIntoView() {

        // The code above means that whenever the method getCharacters() is called
        // return the CharactersResponseModel instance declared.
        CharactersResponseModel charactersResponseModel = new CharactersResponseModel(0,null,null,null);
        when(charactersDataSource.getCharacters()).thenReturn(Observable.just(charactersResponseModel));

        // Now we should instantiate the presenter passing the mocks as dependencies:
        MainPresenter mainPresenter = new MainPresenter(this.charactersDataSource,
                Schedulers.immediate(),Schedulers.immediate(),this.view);
        // One trick here is to “Schedulers.immediate()” as both background and main schedulers so
        // there won’t be a delay when fetching the characters data.

        mainPresenter.loadData();
        InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view, times(1)).onFetchDataStarted();
        inOrder.verify(view,times(1)).onFetchDataSuccess(charactersResponseModel);
        inOrder.verify(view,times(1)).onFetchDataCompleted();

    }
    @Test
    public void fetchErrorShouldReturnErrorToView() {
        Exception exception = new Exception();
        when(charactersDataSource.getCharacters()).thenReturn(Observable.<CharactersResponseModel>error(exception));
        MainPresenter mainPresenter = new MainPresenter(
                this.charactersDataSource,
                Schedulers.immediate(),
                Schedulers.immediate(),
                this.view
        );

        mainPresenter.loadData();

        InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view,times(1)).onFetchDataStarted();
        inOrder.verify(view,times(1)).onFetchDataError(exception);
        verify(view,never()).onFetchDataCompleted();
    }

}
