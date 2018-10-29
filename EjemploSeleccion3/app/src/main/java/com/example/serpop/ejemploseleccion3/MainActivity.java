package com.example.serpop.ejemploseleccion3;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Título 1", "Subtítulo largo 1", R.drawable.img1),
            new Titular("Título 2", "Subtítulo largo 2", R.drawable.img1),
            new Titular("Título 3", "Subtítulo largo 3", R.drawable.img1),
            new Titular("Título 4", "Subtítulo largo 4", R.drawable.img1),
            new Titular("Título 5", "Subtítulo largo 5", R.drawable.img1)
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);

        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0,View arg1, int position, long id){
                String mensaje = "Titulo: "+datos[position].getTitulo()+".Subtitulo:" + datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
            public void onNothinSelected(AdapterView<?>adapterView){

            }
        });
    }
    static class Auxiliar {
        TextView titulo;
        TextView subtitulo;
        ImageView imagen;

    }
    public class AdaptadorTitulares extends ArrayAdapter {


        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            Auxiliar aux;
            if(item == null)
            { LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_titular, null);

                aux = new Auxiliar();
                aux.titulo = (TextView)item.findViewById(R.id.LblTitulo);
                aux.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
                aux.imagen=(ImageView)item.findViewById(R.id.ivimagen);


                item.setTag(aux);
            }
            else {
                aux = (Auxiliar)item.getTag();
            }
            aux.titulo.setText(datos[position].getTitulo());
            aux.subtitulo.setText(datos[position].getSubtitulo());
            aux.imagen.setBackground(getDrawable(datos[position].getImagen()));
            return(item);
        }
    }

}

