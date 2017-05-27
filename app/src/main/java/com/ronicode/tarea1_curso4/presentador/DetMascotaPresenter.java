package com.ronicode.tarea1_curso4.presentador;

import android.content.Context;

import com.ronicode.tarea1_curso4.db.BaseDatos;
import com.ronicode.tarea1_curso4.db.ConstructorMascotas;
import com.ronicode.tarea1_curso4.fragments.IDetalleMascota;
import com.ronicode.tarea1_curso4.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Roni on 26/05/2017.
 */

public class DetMascotaPresenter implements IDetMascotaPresenter {

    private IDetalleMascota iDetalleMascota;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> detalles;
    private BaseDatos db;

    public DetMascotaPresenter (IDetalleMascota iDetalleMascota, Context context){

        this.iDetalleMascota = iDetalleMascota;
        this.context = context;

        favorito();
    }

    @Override
    public void mostrarMascotasRV() {

        iDetalleMascota.inicializarMascotasAdaptadorRV(iDetalleMascota.crearAdaptador(detalles));
        iDetalleMascota.generarLinearLayoutVertical();

    }

    @Override
    public void favorito() {

        db = new BaseDatos(context);
        detalles = db.obtenerMisFavoritos();
        mostrarMascotasRV();

    }
}
