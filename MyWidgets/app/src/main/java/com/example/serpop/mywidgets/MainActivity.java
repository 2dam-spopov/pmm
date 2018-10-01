/*
package com.example.serpop.mywidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHobby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        btnHobby = (Button)findViewById(R.id.btnHobby);
        txtHobby = (TextView)findViewById(R.id.txtHobby);

        btnHobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHobbyClick(v);
            }
        });
    }
    void getHobbyClick(View v) {
        String mensaje = "";
        if (chkBoxTeaching.isChecked())
            mensaje += "enseñar";
        if (chkBoxCycling.isChecked())
            mensaje += "pedalear";
        if (chkBoxBlogging.isChecked())
            mensaje += "blogear";

        txtHobby.setText(mensaje);
    }
}
*/

package com.example.serpop.mywidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    TextView txtHobby1;
    TextView txtHobby2;
    TextView txtHobby3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        txtHobby1 = (TextView) findViewById(R.id.txtHobby1);
        txtHobby2 = (TextView) findViewById(R.id.txtHobby2);

        txtHobby3 = (TextView) findViewById(R.id.txtHobby3);


        chkBoxCycling.setOnCheckedChangeListener(new miChecker());
        chkBoxTeaching.setOnCheckedChangeListener(new miChecker());
        chkBoxBlogging.setOnCheckedChangeListener(new miChecker());

    }


    class miChecker implements CheckBox.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String mensaje1=" ";
            String mensaje2=" ";
            String mensaje3=" ";

            if (isChecked) {
                if (buttonView == chkBoxCycling) {
                    mensaje1 = "Pedalea";
                    txtHobby1.setText(mensaje1);


                }

                if (buttonView == chkBoxTeaching) {
                    mensaje2 = "Enseña";
                    txtHobby2.setText(mensaje2);

                }

                if (buttonView == chkBoxBlogging) {
                    mensaje3 = "Blogea";
                    txtHobby3.setText(mensaje3);

                }

                } else if(isChecked==false){
                if (buttonView == chkBoxCycling) {
                    txtHobby1.setText(mensaje1);


                }

                if (buttonView == chkBoxTeaching) {
                    txtHobby2.setText(mensaje2);

                }

                if (buttonView == chkBoxBlogging) {
                    txtHobby3.setText(mensaje3);

                }



            }


            }



            }


    }



