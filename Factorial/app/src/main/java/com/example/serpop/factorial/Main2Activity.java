package com.example.serpop.factorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final TextView elResultado = (TextView) findViewById(R.id.miLbl);
        Bundle miBundleRecoger=getIntent().getExtras();
        elResultado.setText(miBundleRecoger.getString("cambio"));

    }
}
