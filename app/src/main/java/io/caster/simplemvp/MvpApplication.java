package io.caster.simplemvp;

import android.app.Application;

import hugo.weaving.DebugLog;

public class MvpApplication extends Application {

    private AppComponent component;


    @DebugLog
    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder().appModule(new AppModule()).build();

    }

    @DebugLog
    public AppComponent getComponent() {
        return  component;
    }
}
