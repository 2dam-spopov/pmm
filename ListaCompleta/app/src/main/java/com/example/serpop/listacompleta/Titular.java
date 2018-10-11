package com.example.serpop.listacompleta;

public class Titular {
    String titulo;
    String subtitulo;
    public Titular(String tit, String subTit){
        titulo=tit;
        subtitulo=subTit;

    }
    String getTitutlo(){
        return titulo;
    }
    String getSubTitulo(){
        return subtitulo;
    }

    void setTitulo(String subtit){
        subtitulo=subtit;
    }
    public String toString(){
        return titulo+"    "+subtitulo+"\n";
    }
}
