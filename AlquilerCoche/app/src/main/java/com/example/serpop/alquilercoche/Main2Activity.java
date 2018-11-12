package com.example.serpop.alquilercoche;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        final TextView modelo = (TextView) findViewById(R.id.modelo2);
        final TextView marca = (TextView) findViewById(R.id.marca2);
        final TextView horas = (TextView) findViewById(R.id.horas2);
        final TextView extras = findViewById(R.id.extras2);
        final TextView seguro = (TextView) findViewById(R.id.seguro2);
        final TextView precio = (TextView) findViewById(R.id.precio2);
        final TextView precioHora = findViewById(R.id.precioHora);
        final Button volver = (Button) findViewById(R.id.volver);
        final ImageView imagen = (ImageView) findViewById(R.id.imagen2);
        final CheckBox checkBoxHora = (CheckBox) findViewById(R.id.horaPedido);
        Main3Activity cocheObjeto = (Main3Activity) intent.getSerializableExtra("Objeto");
        float precioTotal;
        modelo.setText(cocheObjeto.getModelo());
        marca.setText(cocheObjeto.getMarca());
        extras.setText(String.valueOf(cocheObjeto.getAire()+cocheObjeto.getGps()+cocheObjeto.getRadio()));
        horas.setText(String.valueOf(cocheObjeto.getHoras()));
        precioHora.setText(String.valueOf(cocheObjeto.getPrecio()));
        seguro.setText(cocheObjeto.getSeguros());

        imagen.setBackground(getDrawable(cocheObjeto.getImagen()));
        if(checkBoxHora.isChecked()){
            Toast.makeText(getApplicationContext(), "14:32", Toast.LENGTH_SHORT).show();
        }



        if(cocheObjeto.getSeguros().equalsIgnoreCase("Sin Seguro")){
            precioTotal = (cocheObjeto.getHoras()*cocheObjeto.getPrecio())+cocheObjeto.getAire()+cocheObjeto.getGps()+cocheObjeto.getRadio();
        }else{
            precioTotal = (cocheObjeto.getHoras()*cocheObjeto.getPrecio())+cocheObjeto.getAire()+cocheObjeto.getGps()+cocheObjeto.getRadio();
            float coste=precioTotal;
            coste*=0.20;
            precioTotal-=coste;
        }



        precio.setText(String.valueOf(precioTotal));
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}