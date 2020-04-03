package aut.bme.hu.quoteapp.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public QuoteApi provideQuoteApi() throws RuntimeException {
        throw new RuntimeException();
    }
}