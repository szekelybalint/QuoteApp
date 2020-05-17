package aut.bme.hu.quoteapp;

public class TestApplication extends QuotesApplication {
    @Override
    public void onCreate(){
        super.onCreate();

        injector =
                DaggerQuotesApplicationComponent.builder()
                        .repositoryModule(new MockRepositoryModule(this))
                        .networkModule(new MockNetworkModule((this)))
                        .build();
    }
}
