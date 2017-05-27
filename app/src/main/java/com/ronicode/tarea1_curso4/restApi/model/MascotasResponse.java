package com.ronicode.tarea1_curso4.restApi.model;

import com.ronicode.tarea1_curso4.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Roni on 26/05/2017.
 */

public class MascotasResponse {

    ArrayList<Mascotas> mascotas;

    public ArrayList<Mascotas> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascotas> mascotas) {
        this.mascotas = mascotas;
    }
}
