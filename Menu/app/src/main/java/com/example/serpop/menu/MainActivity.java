package com.example.serpop.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblMensaje;
    private ImageView miImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblMensaje=findViewById(R.id.lblMensaje);
        miImagen=(ImageView)findViewById(R.id.image);
        registerForContextMenu(miImagen);
        registerForContextMenu(lblMensaje);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.contextual_menu,menu);


    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.MnuOpc1:
                lblMensaje.setText("Opcion 1 pulsada!");
                return true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Opcion 2 pulsada!");
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.CtxOpc1:
                lblMensaje.setText("Opcion 1 pulsada!");
                return true;
            case R.id.CtxOpc2:
                lblMensaje.setText("Opcion 2 pulsada!");
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
