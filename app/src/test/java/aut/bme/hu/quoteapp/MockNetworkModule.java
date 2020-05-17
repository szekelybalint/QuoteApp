package aut.bme.hu.quoteapp;

import android.content.Context;

import javax.inject.Singleton;

import aut.bme.hu.quoteapp.network.NetworkModule;
import aut.bme.hu.quoteapp.network.QuoteApi;
import dagger.Provides;
import retrofit2.Retrofit;

public class MockNetworkModule extends NetworkModule {
    public MockNetworkModule(Context context){
        super(context);
    }

    @Singleton
    @Provides
    @Override
    public QuoteApi provideQuoteApi(Retrofit.Builder builder){
        return new MockQuoteApi();
    }
}
