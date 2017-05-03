package com.mercari.mercaritest;


public interface AppGraph {
    void inject(MercariApp app);
    void inject(MainActivity activity);

    interface Holder {
        AppGraph getAppGraph();
    }
}
