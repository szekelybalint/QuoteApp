package aut.bme.hu.quoteapp;

import android.content.Context;

import javax.inject.Singleton;

import aut.bme.hu.quoteapp.repository.DatabaseRepository;
import aut.bme.hu.quoteapp.repository.RepositoryModule;
import dagger.Provides;

public class MockRepositoryModule extends RepositoryModule {
    Context context;

    public MockRepositoryModule(Context context) {
        super(context);
        this.context = context;
    }

    @Provides
    @Override
    @Singleton
    public DatabaseRepository provideRepository(){
        return new MockRepository(context);
    }

}
