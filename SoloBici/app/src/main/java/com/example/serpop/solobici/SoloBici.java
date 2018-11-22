package com.example.serpop.solobici;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoloBici extends AppCompatActivity {
    private Button BAcercaDe;
    private Button BJuego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView lblMensaje = (TextView)findViewById(R.id.LblMensaje);

        BJuego = (Button)findViewById(R.id.Boton01);
        Boton01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            { 	lanzarJuego();	}
        });
        BAcercaDe = (Button)findViewById(R.id.Boton02);
        Boton021.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                lanzarAcercaDe(); 	}
        });
    }
}