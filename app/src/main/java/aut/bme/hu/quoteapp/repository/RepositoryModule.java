package aut.bme.hu.quoteapp.repository;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    private Context context;

    public RepositoryModule(Context context){
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public DatabaseRepository provideRepository(){
        return new DatabaseRepository(context);
    }
}
