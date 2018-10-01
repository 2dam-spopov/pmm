package com.example.serpop.factorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        final TextView elResultado = (TextView) findViewById(R.id.miLbl);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num=Integer.parseInt(miTexto.getText().toString());
                int resul =1;
                for(int i=1; i<=num; i++){
                    resul = resul*i;
                }
                String resultado= num+"!="+String.valueOf(resul);
                //elResultado.setText(num+"!= "+String.valueOf(resul));
                elResultado.setText(resultado);





                Intent mio=new Intent(MainActivity.this, Main2Activity.class);
                Bundle miBundle=new Bundle();
                miBundle.putString("cambio",resultado);
                mio.putExtras(miBundle);
                startActivity(mio);


            }
        });

    }
}
