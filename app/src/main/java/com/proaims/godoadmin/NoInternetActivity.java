package com.proaims.godoadmin;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by adminpc on 3/12/15.
 */
public class NoInternetActivity extends AppCompatActivity {

    Button tryagain;
    TextView call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_connection);
        tryagain = (Button) findViewById(R.id.tryagain);
        call = (TextView) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+97144232510"));
                startActivity(intent);
            }
        });
        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // User is already logged in. Take him to main activity
                if (isConnectingToInternet()) {
                    Intent intent = new Intent(NoInternetActivity.this,
                            RegistrationPage.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

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
}
