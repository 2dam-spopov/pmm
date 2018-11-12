package com.example.mbp.ejercicioexamen;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class Main2Activity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        final TextView tipoDeBasura = (TextView) findViewById(R.id.tipoDeBsura2);
        final TextView color = (TextView) findViewById(R.id.colores);
        final TextView peso = (TextView) findViewById(R.id.peso2);
        final TextView contenedores = (TextView) findViewById(R.id.contenedores2);
        final TextView precio = (TextView) findViewById(R.id.precio2);
        final TextView tipo=(TextView) findViewById(R.id.tipo);
        final ImageView imagen2 = (ImageView) findViewById(R.id.imagen2);
        final Button volver = (Button) findViewById(R.id.volver);
        Main3Activity colorObjeto = (Main3Activity) intent.getSerializableExtra("Objeto");
        float precioTotal = colorObjeto.getPeso() + colorObjeto.getPrecio();
        tipoDeBasura.setText(colorObjeto.getTipoDeBasura());
        color.setText(colorObjeto.getColor());
        peso.setText(String.valueOf(colorObjeto.getPeso()));
        contenedores.setText(colorObjeto.getContenedores());

        imagen2.setBackground(getDrawable(colorObjeto.getImagen()));

        if(colorObjeto.getContenedores().equalsIgnoreCase("Contenedor Azul")){
            precioTotal = colorObjeto.getPrecio()*colorObjeto.getPeso();
        }else if(colorObjeto.getContenedores().equalsIgnoreCase("Contenedor Amarillo")){
            precioTotal = colorObjeto.getPrecio()*colorObjeto.getPeso();
        }else if(colorObjeto.getContenedores().equalsIgnoreCase("Contenedor Verde")){
            precioTotal = colorObjeto.getPrecio()*colorObjeto.getPeso();
        }else if(colorObjeto.getContenedores().equalsIgnoreCase("Contenedor Marron")){
            precioTotal = colorObjeto.getPrecio()*colorObjeto.getPeso();
        }

        if(colorObjeto.getVender() == true){
            precioTotal += 0;
            tipo.setText("Vender");
        }
        if(colorObjeto.getDonar() == true){

            tipo.setText("Has donado"+String.valueOf(precioTotal)+"€");
        }
        if(colorObjeto.getNada() == true){
            precioTotal = 0;
            tipo.setText("No has hecho nada");
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