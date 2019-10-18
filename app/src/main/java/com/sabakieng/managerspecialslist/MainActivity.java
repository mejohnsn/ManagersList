package com.sabakieng.managerspecialslist;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    String LOGTAG = "MainA";
    Handler mainActivityHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOGTAG, "Created Activity");
    }

    /**
     * Final version of code to read JSON, hence the name.
     * Does everything from opening network connextion to endpoit up
     * to and including setting SpecialsList array with parsed JSON.
     * TODO: find better name
     */
    private void jsonToFinal() {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            String swiftlyEndpoint = "https://prestoq.com/android-coding-challenge";
            String purchaseJsonStr = new OkHttpGet().doGetRequest(swiftlyEndpoint);
            Log.d(LOGTAG, "purchaseJsonStr: " + purchaseJsonStr);
            SpecialsList mgrSpecials = mapper.readValue(purchaseJsonStr, SpecialsList.class);
            Log.d(LOGTAG, " Now: canvasUnit: " + mgrSpecials.canvasUnit + "and the array is: "
                    + "length : " + mgrSpecials.managerSpecials.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // getting ready to do network:
        Thread workerThread = new Thread(new Runnable() {
            public void run() {jsonToFinal();}
        });
        // and start the new worker thread:
        workerThread.start();
    }
}


