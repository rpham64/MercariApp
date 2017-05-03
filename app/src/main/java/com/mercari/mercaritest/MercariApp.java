package com.mercari.mercaritest;

import android.app.Application;


public class MercariApp extends Application implements AppGraph.Holder{

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);
    }

    @Override
    public AppGraph getAppGraph() {
        return appComponent;
    }
}
