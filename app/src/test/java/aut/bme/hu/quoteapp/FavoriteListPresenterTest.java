package aut.bme.hu.quoteapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import aut.bme.hu.quoteapp.model.QuoteEntity;
import aut.bme.hu.quoteapp.ui.favoriteList.FavoriteListActivity;
import aut.bme.hu.quoteapp.ui.favoriteList.FavoriteListPresenter;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Config(application = TestApplication.class)
@RunWith(RobolectricTestRunner.class)
public class FavoriteListPresenterTest {

    @Mock
    FavoriteListActivity activity;

    @Inject
    FavoriteListPresenter presenter;

    @Before
    public void prepare(){
        activity = Mockito.mock(FavoriteListActivity.class);
        TestApplication.injector.inject(activity);
        presenter = activity.presenter;
        presenter.attachScreen(activity);
    }

    @Test
    public void getEmptyDb(){
        presenter.getQuotesFromDatabase();
        verify(activity,times(1)).showQuotes(anyList());
    }
}
