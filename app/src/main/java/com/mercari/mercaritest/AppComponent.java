package com.mercari.mercaritest;


import android.content.Context;

import com.mercari.mercaritest.data.api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class,
})
public interface AppComponent extends AppGraph {

    final class Initializer {
        static AppComponent init(MercariApp app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }

        private Initializer() {}
    }

    final class Holder {
        public static AppGraph get(Context context) {
            return AppGraph.Holder.class.cast(context.getApplicationContext()).getAppGraph();
        }
    }
}
