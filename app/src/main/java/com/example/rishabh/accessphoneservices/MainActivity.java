package com.example.rishabh.accessphoneservices;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CALL = 1;

    private static String[] PERMISSIONS = {
            Manifest.permission.CALL_PHONE
    };
    public static void verifythatCallSomeOne(Activity activity){
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.CALL_PHONE);
        if(permission != PackageManager.PERMISSION_GRANTED){
            //don't have permission ,so prompt the user
            ActivityCompat.requestPermissions(activity,PERMISSIONS,CALL);
        }

    }

    Button btnBiet;
    Button btnGoogle;
    Button btnCallSomeOne;
    Button btndialpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        verifythatCallSomeOne(MainActivity.this);
        btnBiet = findViewById(R.id.button);
        btnGoogle = findViewById(R.id.button2);
        btnCallSomeOne = findViewById(R.id.button3);
        btndialpad = findViewById(R.id.button4);

        btnBiet.setOnClickListener(MainActivity.this);
        btnGoogle.setOnClickListener(MainActivity.this);
        btnCallSomeOne.setOnClickListener(MainActivity.this);
        btndialpad.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.bietjhs.co.in"));
                startActivity(intent);

                break;
            case R.id.button2:

                Intent intent1 = new Intent(Intent.ACTION_WEB_SEARCH);
                intent1.setData(Uri.parse("http://www.google.com"));
                startActivity(intent1);

                break;
            case R.id.button3:
               if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                   ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CALL_PHONE},CALL);
               } else {
                   Intent intent2 = new Intent(Intent.ACTION_CALL);
                   intent2.setData(Uri.parse("8840724568"));
                   startActivity(intent2);
               }
                break;
            case R.id.button4:
                Intent intent3 = new Intent(Intent.ACTION_DIAL);
                startActivity(intent3);
                break;
        }
    }
}
