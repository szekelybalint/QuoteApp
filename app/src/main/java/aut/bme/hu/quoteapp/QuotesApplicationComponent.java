package aut.bme.hu.quoteapp;
import javax.inject.Singleton;

import dagger.Component;
import aut.bme.hu.quoteapp.interactor.QuotesInteractor;
import aut.bme.hu.quoteapp.network.NetworkModule;
import aut.bme.hu.quoteapp.ui.UIModule;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListActivity;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListPresenter;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListScreen;


@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface QuotesApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(QuoteListScreen quoteListScreen);

    void inject(QuoteListPresenter quoteListPresenter);

    void inject(QuotesInteractor quotesInteractor);
}
