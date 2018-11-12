package com.example.serpop.alquilercoche;


import android.widget.ImageView;
import java.io.Serializable;
public class Main3Activity implements Serializable{
    public String modelo, marca, seguros;
    public float precio, horas;
    public float aire , gps,radio;
    public int imagen;

    public Main3Activity(String modelo, String marca, float precio, float horas, String seguros, float aire, float gps, float radio, int imagen){
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.horas = horas;
        this.seguros = seguros;
        this.aire = aire;
        this.gps = gps;
        this.radio = radio;
        this.imagen = imagen;

    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getModelo(){
        return this.modelo;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return this.marca;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }
    public float getPrecio(){
        return this.precio;
    }

    public void setHoras(float horas){
        this.horas = horas;
    }
    public float getHoras(){
        return this.horas;
    }

    public void setSeguros(String seguros){
        this.seguros = seguros;
    }
    public String getSeguros(){
        return this.seguros;
    }

    public void setAire(float aire){
        this.aire = aire;
    }
    public float getAire(){
        return this.aire;
    }

    public void setGps(float gps){
        this.gps = gps;
    }
    public float getGps(){
        return this.gps;
    }

    public void setRadio(float radio){
        this.radio = radio;
    }
    public float getRadio(){
        return this.radio;
    }

    public void setImagen(int imagen){
        this.imagen = imagen;
    }
    public int getImagen(){
        return this.imagen;
    }

    public String toString(){
        return "Modelo: " + this.modelo + ". Marca: " + this.marca + " Precio: " + this.precio  + ". Seguro: " + this.seguros + ". Aire: " + this.aire + ". GPS: " + this.gps + ". Radio: "+this.radio;
    }
}