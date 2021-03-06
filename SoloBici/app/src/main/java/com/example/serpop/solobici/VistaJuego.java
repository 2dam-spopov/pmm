package com.example.serpop.solobici;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.Vector;

public class VistaJuego extends View {

    //COCHES
    private Vector<Grafico> Coches; //Vector con los coches
    private int numCoches = 5; //Número oficial de Coches
    private int numMotos = 3; //Fragmentos/Motos en que se divide un coche

    //BICI
    private Grafico bici;
    private int giroBici; //Incremento dirección de la bici
    private float aceleracionBici; //Aumento de velocidad de la bici
    private static final int PASO_GIRO_BICI = 5;
    private static final float PASO_ACELERACION_BICI = 0.5f;

    //THREAD Y TIEMPO
    //Hilo encargado de procesar el tiempo
    private HiloJuego hiloJuego;
    //Tiempo que debe transcurrir para procesar cambios (ms)
    private static int PERIODO_PROCESO = 50;

    private static int MAX_VELOCIDAD = 20;




    //Momento en el que se realiza el último proceso
    private long ultimoProceso = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VistaJuego(Context contexto, AttributeSet atributos) {
        super(contexto, atributos);
        Drawable graficoBici, graficoCoche, graficoRueda;
        //Obtenemos la imagen del coche
        graficoCoche = contexto.getResources().getDrawable(R.drawable.coche);

        //Creamos un vector para contener todos los coches que se ven en la pantalla
        //y lo rellenamos con graficos de coches
        //con valores aleatorios para su velocidad, dirección y velocidad.
        Coches = new Vector<Grafico>();
        for (int i = 0; i < numCoches; i++) {
            Grafico coche = new Grafico(this, graficoCoche);
            coche.setIncX(Math.random() * 4 - 2);
            coche.setIncY(Math.random() * 4 - 2);
            coche.setAngulo((int) (Math.random() * 360));
            coche.setRotacion((int) (Math.random() * 8 - 4));
            Coches.add(coche);
        }

        //BICI
        graficoBici = contexto.getResources().getDrawable(R.drawable.bici);
        bici = new Grafico(this, graficoBici);
    }

    //Al comenzar y dibujar por primera vez en la pantalla del juego
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //Dibujamos los coches en posiciones aleatorias
        for (Grafico coche : Coches) {
            do {
                coche.setPosX(Math.random() * (w - coche.getAncho()));
                coche.setPosY(Math.random() * (h - coche.getAlto()));
            } while (coche.distancia(bici) < (w + h) / 5);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Dibujamos cada uno de los coches
        for (Grafico coche : Coches) {
            coche.dibujaGrafico(canvas);
        }
    }

    protected synchronized void actualizaMovimiento(){
        long ahora = System.currentTimeMillis();
        //No hacemos nada si el período de proceso no se ha cumplido.
        if(ultimoProceso+PERIODO_PROCESO>ahora){
            return;
        }
        //Para una ejecución en tiempo real calculamos retardo.
        double retardo = (ahora - ultimoProceso)/ PERIODO_PROCESO;
        //Actualizamos la posición de la bici.

        bici.setAngulo((int)(bici.getAngulo()+giroBici*retardo));
        double nIncX=bici.getIncX()+aceleracionBici * Math.cos(Math.toRadians(bici.getAngulo()))*retardo;
        double nIncY=bici.getIncY()+aceleracionBici * Math.cos(Math.toRadians(bici.getAngulo()))*retardo;
        if(Grafico.distanciaE(0,0,nIncX,nIncY)<= MAX_VELOCIDAD){
            bici.setIncX(nIncX);
            bici.setIncY(nIncY);
        }
        bici.incrementaPos();
        //Movemos los coches
        for(Grafico coche : Coches){
            coche.incrementaPos();
        }
        ultimoProceso = ahora;
    }
    private class HiloJuego extends Thread{
        public void run(){
            while(true){
                actualizaMovimiento();
            }
        }
    }

}
