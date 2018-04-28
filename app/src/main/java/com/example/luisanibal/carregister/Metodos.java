package com.example.luisanibal.carregister;

import java.util.ArrayList;
import java.util.Random;

public class Metodos {

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }

}
