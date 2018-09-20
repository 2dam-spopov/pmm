package com.example.serpop.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView otroSaludo=(TextView)findViewById(R.id.miLbl);
        Bundle miBundleRecoger=getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
    }
}