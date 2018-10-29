package com.example.serpop.dibujo2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new miDibujo(this));
        Toast.makeText(this,"Dibujar Circulo",Toast.LENGTH_SHORT).show();

    }

    class miDibujo extends View {
        private ShapeDrawable miDrawable;

        public miDibujo(Context c) {
            super(c);
        }

        public miDibujo(Context c, AttributeSet a) {
            super(c, a);
        }
        protected void onDraw(Canvas lienzo){
            Paint miPincel=new Paint();
            miPincel.setColor(Color.RED);
            miPincel.setStyle(Paint.Style.STROKE);
            lienzo.drawCircle(500,500,300, miPincel);

            miPincel.setTextSize(60);
            lienzo.drawText("MI CIRCULO", 500,900, miPincel);
            String mensaje="Ancho: "+getWidth()+"Alto"+getHeight();
            lienzo.drawText(mensaje,500,1000,miPincel);
            Toast.makeText(getApplicationContext(),"mas dibujos",Toast.LENGTH_SHORT).show();
        }

    }

}
