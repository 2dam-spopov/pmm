package com.example.mbp.ejercicioexamen;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Main3Activity[] tipos = new Main3Activity[]{
            new Main3Activity("Papel", "Azul", 5, 0,"", false, false, false, R.drawable.azul),
            new Main3Activity("Plástico", "Amarillo", 10, 0, "",false, false,false, R.drawable.amarillo),
            new Main3Activity("Vidrio", "Verde", 15, 0, "",false, false,false, R.drawable.verde),
            new Main3Activity("Orgánico", "Marrón", 3, 0, "",false, false,false, R.drawable.marron)
    };
    public Main3Activity [] micolor;
    public int indice = 0;
    public Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorColores miAdaptador = new AdaptadorColores(this);
        spinner.setAdapter(miAdaptador);
        spinner.setSelection(-1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                indice = pos;
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        final RadioButton botonAzul = (RadioButton)
                findViewById(R.id.contenedorAzul);
        final RadioButton botonAmarillo = (RadioButton)
                findViewById(R.id.contenedorAmarillo);
        final RadioButton botonVerde = (RadioButton)
                findViewById(R.id.contenedorVerde);
        final RadioButton botonMarron = (RadioButton)
                findViewById(R.id.contenedorMarron);
        final CheckBox checkBoxVender = (CheckBox) findViewById(R.id.vender);
        final CheckBox checkBoxDonar = (CheckBox) findViewById(R.id.donar);
        final CheckBox checkBoxNada = (CheckBox) findViewById(R.id.nada);
        Button calcular = (Button) findViewById(R.id.calcular);
        final RadioGroup contenedores = (RadioGroup) findViewById(R.id.contenedores);
        final TextView resultado = (TextView) findViewById(R.id.resultado);
        final EditText peso = (EditText) findViewById(R.id.peso);
        final Object texto = spinner.getSelectedItem();
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = false;
                if(botonAzul.isChecked()){
                    tipos[indice].setContenedores("Contenedor Azul");
                    flag = true;

                }else if(botonAmarillo.isChecked()){
                    tipos[indice].setContenedores("Contenedor Amarillo");
                    flag = true;
                }else if(botonVerde.isChecked()){
                    tipos[indice].setContenedores("Contenedor Verde");
                    flag = true;
                }else if(botonMarron.isChecked()){
                    tipos[indice].setContenedores("Contenedor Marron");
                    flag = true;
                }else{
                    Toast.makeText(getApplicationContext(), "Debes seleccionar un contenedor",Toast.LENGTH_SHORT).show();
                        flag = false;
                }
                if(checkBoxVender.isChecked()){
                    tipos[indice].setVender(true);
                }else if(checkBoxDonar.isChecked()){
                    tipos[indice].setDonar(true);
                }else if(checkBoxNada.isChecked()){
                    tipos[indice].setNada(true);
                }
                String comparador = peso.getText().toString();
                if(comparador.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Debes introducir un peso",Toast.LENGTH_SHORT).show();
                            flag = false;
                }else{
                    tipos[indice].setPeso(Float.parseFloat(peso.getText().toString()));
                }
                if (flag == true){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Objeto", tipos[indice]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                resultado.setText(tipos[indice].toString());
            }
        });
    }
    class AdaptadorColores extends ArrayAdapter{
        Activity context;
        AdaptadorColores(Activity context){
            super(context, R.layout.activity_main3, tipos);
            this.context = context;
        }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vista = getView(position, convertView, parent);
            return vista;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int position, View convertiView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_main3, null);
            TextView tipoDeBasura = (TextView) item.findViewById(R.id.tipoDeBasura);
            TextView color = (TextView) item.findViewById(R.id.color);
            TextView precio = (TextView) item.findViewById(R.id.precio);
            ImageView imagen = (ImageView) item.findViewById(R.id.imagenSpinner);
            tipoDeBasura.setText(tipos[position].getTipoDeBasura());
            color.setText(tipos[position].getColor());
            precio.setText(String.valueOf(tipos[position].getPrecio()));
            imagen.setBackground(getDrawable(tipos[position].getImagen()));
            return item;
        }
    }
}