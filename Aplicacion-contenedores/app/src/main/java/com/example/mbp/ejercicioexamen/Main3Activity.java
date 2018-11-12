package com.example.mbp.ejercicioexamen;
import java.io.Serializable;
public class Main3Activity implements Serializable{
    public String tipoDeBasura, color, contenedores;
    public float precio, peso;
    public boolean vender = false, donar = false, nada = false;
    public int imagen;

    public Main3Activity(String tipoDeBasura, String color, float precio, float peso, String contenedores, boolean vender, boolean donar, boolean nada, int imagen){
        this.tipoDeBasura = tipoDeBasura;
        this.color = color;
        this.precio = precio;
        this.peso = peso;
        this.contenedores = contenedores;
        this.vender = vender;
        this.donar = donar;
        this.nada = nada;
        this.imagen = imagen;

    }
    public void setTipoDeBasura(String tipoDeBasura){
        this.tipoDeBasura = tipoDeBasura;
    }
    public String getTipoDeBasura(){
        return this.tipoDeBasura;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }
    public float getPrecio(){
        return this.precio;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }
    public float getPeso(){
        return this.peso;
    }
    public void setContenedores(String contenedores){
        this.contenedores = contenedores;
    }
    public String getContenedores(){
        return this.contenedores;
    }
    public void setVender(boolean vender){
        this.vender = vender;
    }
    public boolean getVender(){
        return this.vender;
    }
    public void setDonar(boolean donar){
        this.donar = donar;
    }
    public boolean getDonar(){
        return this.donar;
    }
    public void setNada(boolean nada){
        this.nada = nada;
    }
    public boolean getNada(){
        return this.nada;
    }
    public void setImagen(int imagen){
        this.imagen = imagen;
    }
    public int getImagen(){
        return this.imagen;
    }

    public String toString(){
        return "Tipo de basura: " + this.tipoDeBasura + ". Color: " + this.color + " Peso: " + this.peso  + ". Contenedor: " + this.contenedores + ". Vender: " + this.vender + ". Donar: " + this.donar + ". Nada: "+ this.nada;
    }
}