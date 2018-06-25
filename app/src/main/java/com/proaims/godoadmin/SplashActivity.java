package com.proaims.godoadmin;

/**
 * Created by adminpc on 4/1/16.
 */

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;
    SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        LinearLayout iv = (LinearLayout) findViewById(R.id.llcen);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc_slide_in_bottom);
        iv.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                // User is already logged in. Take him to main activity
                if (isConnectingToInternet()) {
                    Intent intent = new Intent(SplashActivity.this,
                            RegistrationPage.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Toast.makeText(SplashActivity.this, "Please ckeck your internet connection and try again.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SplashActivity.this,
                            NoInternetActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, SPLASH_TIME_OUT);
    }

    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

}