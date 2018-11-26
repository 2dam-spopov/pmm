package com.example.serpop.solobici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoloBici extends AppCompatActivity {
    private Button bAcercaDe;
    private Button bJuego;
    private Button bPreferencias;
    private Button bSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_bici);
        final TextView lblMensaje = (TextView)findViewById(R.id.LblMensaje);

        //Botón y escuchador para la pantalla de "Juego"
        bJuego = (Button)findViewById(R.id.Boton01);
        bJuego.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                lanzarJuego();
            }

    });
        //Botón para la pantalla "Acerca de"
        bAcercaDe=(Button) findViewById(R.id.Boton03);
        bAcercaDe.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                lanzarAcercaDe();
            }
        });

}
    public void lanzarJuego(){
        Intent i = new Intent(this, Juego.class);
        startActivity(i);
    }
    //Método que activa la pantalla AcercaDe
    public void lanzarAcercaDe(){
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }
}