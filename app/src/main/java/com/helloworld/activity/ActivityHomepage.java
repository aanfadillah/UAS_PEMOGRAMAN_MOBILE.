package com.helloworld.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.helloworld.R;

public class ActivityHomepage extends AppCompatActivity {
    ImageView btnHello;
    ImageView btnCount;
    ImageView btnScrollice;
    ImageView btnTwoActivity;
    ImageView btnAlarm;
    ImageView btnMaps;
    ImageView btnPbeauty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btnHello = (ImageView) findViewById(R.id.btnHello);
        btnCount = (ImageView) findViewById(R.id.btnCount);
        btnScrollice = (ImageView) findViewById(R.id.btnScrollice);
        btnTwoActivity = (ImageView) findViewById(R.id.btnTwoActivity);
        btnAlarm = (ImageView) findViewById(R.id.btnAlarm);
        btnMaps = (ImageView) findViewById(R.id.btnMaps);
        btnPbeauty = (ImageView) findViewById(R.id.btnFragment);

        clickListener();
    }

    public void clickListener() {
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helloIntent = new Intent(ActivityHomepage.this, MainActivity.class);
                startActivity(helloIntent);
            }
        });

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent countIntent = new Intent(ActivityHomepage.this, CountActivity.class);
                startActivity(countIntent);
            }
        });

        btnScrollice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scrolliceIntent = new Intent(ActivityHomepage.this, ScrollingActivity.class);
                startActivity(scrolliceIntent);
            }
        });

        btnTwoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twoIntent = new Intent(ActivityHomepage.this, FirstActivity.class);
                startActivity(twoIntent);
            }
        });

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AlarmIntent = new Intent(ActivityHomepage.this, AlarmActivity.class);
                startActivity(AlarmIntent);
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmm = Uri.parse("google.streetview:cbll=46.414382,10.013988");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmm);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        btnPbeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(ActivityHomepage.this, FragmentActivity.class);
                startActivity(Intent);
            }
        });
    }
}