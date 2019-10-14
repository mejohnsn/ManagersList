package com.sabakieng.managerspecialslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MainActivity extends AppCompatActivity {
    String LOGTAG = "MainA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOGTAG, "Created Activity");
        jsonToFinal();  // this uses hand-typed version of real JSON for the challenge
    }

    private void jsonToFinal() { // TODO: fix start of string.
        final ObjectMapper mapper = new ObjectMapper();
        try {
            String purchaseJsonStr =
                    "{ \"canvasUnit\" : \"16\", \"managerSpecials\" : [{\"display_name\":\"Noodle Dish with Roasted Black Bean Sauce\",\"height\": 8,"
                            + "\"imageUrl\": \"https://raw.githubusercontent.com/prestoqinc/code-exercise-android/master/images/L.png\",\"original_price\": \"2.00\",\"price\": \"1.00\","
                            + "\"width\": 16},"
                            + "{\"display_name\": \"Onion Flavored Rings\", \"height\": 8,\"imageUrl\":"
                            + "\"https://raw.githubusercontent.com/prestoqinc/code-exercise-android/master/images/J.png\","
                            + "\"original_price\": \"2.00\", \"price\": \"1.00\","
                            + "\"width\": 8 },"

                            + " {\"display_name\": \"Kikkoman Less Sodium Soy Sauce\","
                            + " \"height\": 8,"
                            + "\"imageUrl\": \"https://raw.githubusercontent.com/prestoqinc/code-exercise-android/master/images/K.png\","
                            + "\"original_price\": \"2.00\","
                            + "\"price\": \"1.00\", \"width\": 8 }  ] }";
            Log.d(LOGTAG, "purchaseJsonStr: " + purchaseJsonStr);
            SpecialsList mgrSpecials = mapper.readValue(purchaseJsonStr, SpecialsList.class);
            Log.d(LOGTAG, " Now: canvasUnit: " + mgrSpecials.canvasUnit + "and the array is: "
                    + "length : " + mgrSpecials.managerSpecials.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


