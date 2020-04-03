package aut.bme.hu.quoteapp;

import android.app.Application;

import aut.bme.hu.quoteapp.ui.UIModule;

public class QuotesApplication extends Application {

    public static QuotesApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerQuotesApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
