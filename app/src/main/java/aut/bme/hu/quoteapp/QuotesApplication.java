package aut.bme.hu.quoteapp;

import android.app.Application;

import aut.bme.hu.quoteapp.network.NetworkModule;
import aut.bme.hu.quoteapp.repository.RepositoryModule;
import aut.bme.hu.quoteapp.ui.UIModule;

public class QuotesApplication extends Application {

    public static QuotesApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerQuotesApplicationComponent.builder()
                        .repositoryModule(new RepositoryModule(this))
                        .networkModule(new NetworkModule((this)))
                .build();
    }
}
