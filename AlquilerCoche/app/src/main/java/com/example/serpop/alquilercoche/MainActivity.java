package com.example.serpop.alquilercoche;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    public Main3Activity[] coche = new Main3Activity[]{
            new Main3Activity("Megane", "Seat", 20, 0,"", 0, 0, 0, R.drawable.megan1),
            new Main3Activity("X-11", "Ferrari", 100, 0,"", 0, 0, 0, R.drawable.ferrari1),
            new Main3Activity("Leon", "Seat", 30, 0,"", 0, 0, 0, R.drawable.leon1),
            new Main3Activity("Fiesta", "Ford", 40, 0,"", 0, 0, 0, R.drawable.fiesta1),
    };



    public Main3Activity [] mizona;
    public int indice = 0;
    public Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorCoches miAdaptador = new AdaptadorCoches(this);
        spinner.setAdapter(miAdaptador);
        spinner.setSelection(-1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                indice = pos;
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        final RadioButton botonSinSeguro = (RadioButton)
                findViewById(R.id.sinSeguro);
        final RadioButton botonSeguroTodo = (RadioButton)
                findViewById(R.id.seguroTodo);
        final CheckBox checkBoxAire = (CheckBox) findViewById(R.id.aire);
        final CheckBox checkBoxGps = (CheckBox) findViewById(R.id.gps);
        final CheckBox checkBoxRadio = (CheckBox) findViewById(R.id.radio);
        Button calcular = (Button) findViewById(R.id.calcular);
        final RadioGroup seguro = (RadioGroup) findViewById(R.id.seguro);
        final TextView resultado = (TextView) findViewById(R.id.resultado);
        final EditText horas = (EditText) findViewById(R.id.horas);
        final Object texto = spinner.getSelectedItem();
        calcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean flag = false;
                if(botonSinSeguro.isChecked()){
                    coche[indice].setSeguros("Sin Seguro");
                    flag = true;

                }else if(botonSeguroTodo.isChecked()){
                    coche[indice].setSeguros("Seguro Todo Riesgo");
                    flag = true;
                }else{
                    Toast.makeText(getApplicationContext(), "Debes seleccionar un seguro",Toast.LENGTH_SHORT).show();

                    flag = false;
                }
                float extra=0;
                if(checkBoxAire.isChecked()){
                    extra=50;
                    coche[indice].setAire(extra);
                }if(checkBoxGps.isChecked()){
                    extra=50;
                    coche[indice].setGps(extra);
                }if(checkBoxRadio.isChecked()){
                    extra=50;
                    coche[indice].setRadio(extra);
                }



                String comparador = horas.getText().toString();
                if(comparador.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Debes introducir las horas",Toast.LENGTH_SHORT).show();
                    flag = false;
                }else{
                    coche[indice].setHoras(Float.parseFloat(horas.getText().toString()));
                }
                if (flag == true){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Objeto", coche[indice]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                resultado.setText(coche[indice].toString());
            }
        });





    }
    class AdaptadorCoches extends ArrayAdapter{
        Activity context;
        AdaptadorCoches(Activity context){
            super(context, R.layout.activity_main3, coche);
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
            TextView modelo = (TextView) item.findViewById(R.id.modelo);
            TextView marca = (TextView) item.findViewById(R.id.marca);
            TextView precio = (TextView) item.findViewById(R.id.precio);
            ImageView imagen = (ImageView) item.findViewById(R.id.imagenSpinner);
            modelo.setText(coche[position].getModelo());
            marca.setText(coche[position].getMarca());
            precio.setText(String.valueOf(coche[position].getPrecio()));
            imagen.setBackground(getDrawable(coche[position].getImagen()));
            return item;
        }
    }



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        String mensaje="";
        switch (item.getItemId()){
            case R.id.MnuOpc1:
                Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
            }



    }




}