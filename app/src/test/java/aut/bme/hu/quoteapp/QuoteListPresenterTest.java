package aut.bme.hu.quoteapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListPresenter;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class QuoteListPresenterTest {

    @Inject
    QuoteListPresenter quoteListPresenter;

    @Mock
    MainActivity activity;

    @Captor
    ArgumentCaptor<ArrayList<Quote>> captor = ArgumentCaptor.forClass((Class<ArrayList<Quote>>) (Class)ArrayList.class);

    @Before
    public void prepare(){
        activity = Mockito.mock(MainActivity.class);
        TestApplication.injector.inject(activity);
        quoteListPresenter = activity.presenter;
        quoteListPresenter.attachScreen(activity);
    }

    @Test
    public void apiTest(){
        try {
            quoteListPresenter.getQuotesFromInteractor();

            verify(activity, times(1)).showQuotes(captor.capture());

            List<Quote> argVal = captor.getValue();
            Assert.assertEquals("Marcus Aurelius",argVal.get(0).getAuthor());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void dbTest(){
        try {
            quoteListPresenter.getQuotesFromInteractor();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        quoteListPresenter.addFavorite(0);
        quoteListPresenter.getQuotesFromDatabase();

        verify(activity, times(2)).showQuotes(captor.capture());

        List<Quote> argVal = captor.getValue();
        Assert.assertEquals("Marcus Aurelius",argVal.get(0).getAuthor());
        Assert.assertEquals("Ha nem gondolod azt, hogy bántalom ért, akkor nem is ért bántalom, s ha nem ért bántalom, akkor kárt sem szenvedtél.", argVal.get(0).getQuoteText());
    }
}
