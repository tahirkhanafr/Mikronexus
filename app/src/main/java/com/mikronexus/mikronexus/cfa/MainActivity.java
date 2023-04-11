package com.mikronexus.mikronexus.cfa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    String appId = "com.mikronexus.dejavoo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        button=findViewById(R.id.Proceed);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appId);
                if (launchIntent != null) {
                    startActivity(launchIntent);// start the activity of other app
                } else {
                    Toast.makeText(MainActivity.this, "Other app not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}