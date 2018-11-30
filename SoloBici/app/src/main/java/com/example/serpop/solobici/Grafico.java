package com.example.serpop.solobici;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Grafico  {

    private Drawable drawable; //Imagen que se dibuja
    private double posX, posY; //Posición en la pantalla
    private double incX, incY; //Velocidad de desplazamiento
    private int angulo, rotacion; //
    private int ancho, alto; //Dimensiones de la imagen
    private int radioColision; //Determinar si chocamos


    //CONSTRUCTOR
    public Grafico(Drawable drawable, double posX, double posY, double incX, double incY, int angulo, int rotacion, int ancho, int alto, int radioColision) {
        this.drawable = drawable;
        this.posX = posX;
        this.posY = posY;
        this.incX = incX;
        this.incY = incY;
        this.angulo = angulo;
        this.rotacion = rotacion;
        this.ancho = ancho;
        this.alto = alto;
        this.radioColision = radioColision;
    }


    //GETTERS Y SETTERS
    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getIncX() {
        return incX;
    }

    public void setIncX(double incX) {
        this.incX = incX;
    }

    public double getIncY() {
        return incY;
    }

    public void setIncY(double incY) {
        this.incY = incY;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public int getRotacion() {
        return rotacion;
    }

    public void setRotacion(int rotacion) {
        this.rotacion = rotacion;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getRadioColision() {
        return radioColision;
    }

    public void setRadioColision(int radioColision) {
        this.radioColision = radioColision;
    }




    //TOSTRING
    @Override
    public String toString() {
        return "Grafico{" +
                "drawable=" + drawable +
                ", posX=" + posX +
                ", posY=" + posY +
                ", incX=" + incX +
                ", incY=" + incY +
                ", angulo=" + angulo +
                ", rotacion=" + rotacion +
                ", ancho=" + ancho +
                ", alto=" + alto +
                ", radioColision=" + radioColision +
                '}';
    }

    //Vista donde dibujamos el gráfico
    private View view;
    //Para de terminar el espacio a borrar
    public static final int MAX_VELOCIDAD=20;

    //Inicializamos los atributos de esta clase
    public Grafico(View view,Drawable drawable){
        this.view=view;
        this.drawable=drawable;
        ancho=drawable.getIntrinsicWidth();
        alto=drawable.getIntrinsicHeight();
        radioColision=(alto+ancho)/4;
    }

    //Dibujamos el gráfico en su posición actual
    public void dibujaGrafico(Canvas canvas){
        canvas.save();
        int x = (int) (posX + ancho / 2);
        int y = (int) (posY + alto / 2);
        canvas.rotate((float) angulo,(float) x,(float) y);
        drawable.setBounds((int) posX,(int) posY,(int) posX+ancho,(int) posY+alto );
        drawable.draw(canvas);
        canvas.restore();
        //Calcula área donde no podrán solaparse/chocar
        //otro gráficos con este
        int rInval=(int) distanciaE(0,0,ancho,alto)/2+MAX_VELOCIDAD;
        view.invalidate(x-rInval,y-rInval,x+rInval,y+rInval);
    }

    //Corrección posición si el gráfico sale de la pantalla
    //En estos casos aparece por el otro lado de la pantalla
    public void incrementaPos() {
        //Si salimos de la pantalla, corregimos posición
        posX += incX;
        if (posX < -ancho / 2) {
            posX = view.getWidth() - ancho / 2;
        }
        if (posX > view.getWidth() - ancho / 2) {
            posX = -ancho / 2;
        }

        posY += incY;
        if (posY < -ancho / 2) {
            posY = view.getWidth() - ancho / 2;
        }
        if (posY > view.getWidth() - ancho / 2) {
            posY = -ancho / 2;
        }
        //Actualizamos ángulo
        angulo += rotacion;
    }
    //Nos devuelve la distancia entre dos objetos Gráfico
    public double distancia(Grafico g){
        return distanciaE(posX, posY, g.posX, g.posY);
    }
    //Nos devuelve si se produce o no colisión
    public boolean verificaColision(Grafico g){
        return (distancia(g)<(radioColision+g.radioColision));
    }
    public static double distanciaE(double x, double y, double x2, double y2){
        return Math.sqrt((x-x2)*(x-x2)+(y-y2)*(y-y2));
    }
}