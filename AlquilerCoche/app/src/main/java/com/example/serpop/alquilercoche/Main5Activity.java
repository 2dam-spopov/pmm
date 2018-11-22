package com.example.serpop.alquilercoche;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

public class Main5Activity  extends View {
    public Main5Activity(Context contexto) {
        super(contexto);
    }
    public Main5Activity(Context contexto, AttributeSet atts) {
        super(contexto,atts);

    }
    private ShapeDrawable miDrawable;
    protected void onDraw(Canvas canvas) {
        Paint pincelA = new Paint();
        pincelA.setColor(Color.BLUE);
        pincelA.setStrokeWidth(100);
        pincelA.setStyle(Paint.Style.STROKE);



        Paint pincelR = new Paint();
        pincelR.setColor(Color.RED);
        pincelR.setStrokeWidth(10);
        pincelR.setStyle(Paint.Style.STROKE);


        Paint pincelV = new Paint();
        pincelV.setColor(Color.BLACK);
        pincelV.setStrokeWidth(30);
        pincelV.setStyle(Paint.Style.STROKE);


        //canvas.drawCircle(300, 1154, 75, pincelV);
        //canvas.drawCircle(900, 1154, 75, pincelV);
        //canvas.drawRect(200,700,1200,1150,pincelR);
        //canvas.drawLine(700,700,700,1150,pincelR);



            int x=500;int y=1300;
            int ancho = 300 , alto = 500;
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x,y,x+ancho,y+alto);
            miDrawable.draw(canvas);

    }
}