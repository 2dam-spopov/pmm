package com.example.serpop.ejemploseleccion4;

import android.media.Image;

public class Titular {
    private String titulo;
    private String subtitulo;
    private  int image;

    public Titular(String tit, String sub, int img1) {
        titulo = tit;
        subtitulo = sub;
        image = img1;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }
    public int getImagen(){
        return image;
    }
}
