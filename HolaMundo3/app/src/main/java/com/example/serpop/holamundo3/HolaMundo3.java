package com.example.serpop.holamundo3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HolaMundo3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo3);

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        final TextView elSaludo = (TextView) findViewById(R.id.miLbl);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux="Te saludo "+ miTexto.getText();
                elSaludo.setText(aux);
                Intent mio=new Intent(HolaMundo3.this, HolaMundo32.class);
                Bundle miBundle=new Bundle();
                miBundle.putString("paso",aux);
                mio.putExtras(miBundle);
                startActivity(mio);
                MediaPlayer miMusica=MediaPlayer.create(getApplicationContext(),R.raw.risas);
                miMusica.start();
            }
        });
    }

    @Override protected void onStart() {
        super.onStart();
        Toast.makeText(HolaMundo3.this, "A1: onStart", Toast.LENGTH_SHORT).show();
        System.out.println("A1: onStart");
    }
    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(HolaMundo3.this, "A1: onResume", Toast.LENGTH_SHORT).show();
        System.out.println("A1: onResume");
    }
    @Override protected void onPause() {
        Toast.makeText(HolaMundo3.this, "A1: onPause", Toast.LENGTH_SHORT).show();
        System.out.println("A1: onPause");
        super.onPause();
    }
    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(HolaMundo3.this, "A1: onStop", Toast.LENGTH_SHORT).show();
        System.out.println("A1: onStop");
    }
}
