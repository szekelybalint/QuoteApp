package aut.bme.hu.quoteapp.network;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private Context context;

    public NetworkModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create());
    }

    @Provides
    @Singleton
    public QuoteApi provideQuoteApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl("http://www.mocky.io/v2/")
                .build()
                .create(QuoteApi.class);
    }
}