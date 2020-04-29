package com.google.firebase.quickstart.auth.troc_on_line;

import android.app.Application;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyConfig.Builder;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class App  extends Application {
    @Override
    public  void onCreate(){
        super.onCreate();
        ViewPump.init(ViewPump.builder()
        .addInterceptor(new CalligraphyInterceptor(
                new Builder()
                .setDefaultFontPath("fonts/boston_traffic.ttf")
                        .setFontAttrId(R.attr.fontPath)
                .build()))
        .build());
    }
}
