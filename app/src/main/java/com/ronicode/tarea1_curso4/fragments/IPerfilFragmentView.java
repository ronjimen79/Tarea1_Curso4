package com.ronicode.tarea1_curso4.fragments;

import com.ronicode.tarea1_curso4.adaptadores.MascotasAdaptador;
import com.ronicode.tarea1_curso4.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Roni on 26/05/2017.
 */

public interface IPerfilFragmentView {

    public void generarLinearLayoutVertical();
    public void generarGridLayout();
    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> detalles);
    public void inicializarMascotasAdaptadorRV (MascotasAdaptador mascotasAdaptador);
}
