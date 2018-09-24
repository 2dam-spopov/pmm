package com.example.serpop.holamundo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

public class HolaMundo32 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo32);

        final TextView elSaludo2 = (TextView) findViewById(R.id.miLbl);
        final ImageButton miImagen = (ImageButton) findViewById(R.id.miImg);

        Bundle miBundleRecoger=getIntent().getExtras();
        elSaludo2.setText(miBundleRecoger.getString("paso"));

        miImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver=new Intent(HolaMundo32.this, HolaMundo3.class);
                startActivity(volver);
            }
        });


    }

    @Override protected void onStart() {
        super.onStart();
        Toast.makeText(HolaMundo32.this, "A2: onStart", Toast.LENGTH_SHORT).show();
        System.out.println("A2: onStart");
    }
    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(HolaMundo32.this, "A2: onResume", Toast.LENGTH_SHORT).show();
        System.out.println("A2: onResume");
    }
    @Override protected void onPause() {
        Toast.makeText(HolaMundo32.this, "A2: onPause", Toast.LENGTH_SHORT).show();
        System.out.println("A2: onPause");
        super.onPause();
    }
    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(HolaMundo32.this, "A2: onStop", Toast.LENGTH_SHORT).show();
        System.out.println("A2: onStop");
    }

}
