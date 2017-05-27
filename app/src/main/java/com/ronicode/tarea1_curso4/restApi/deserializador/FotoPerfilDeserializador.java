package com.ronicode.tarea1_curso4.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ronicode.tarea1_curso4.pojo.Mascotas;
import com.ronicode.tarea1_curso4.restApi.JsonKeys;
import com.ronicode.tarea1_curso4.restApi.model.MascotasResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Roni on 26/05/2017.
 */

public class FotoPerfilDeserializador implements JsonDeserializer<MascotasResponse> {

    public static String nombreCompleto;
    public static String urlFoto;

    @Override
    public MascotasResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        MascotasResponse mascotasResponse = gson.fromJson(json, MascotasResponse.class);

        JsonObject data = json.getAsJsonObject().getAsJsonObject(JsonKeys.DATA);
        mascotasResponse.setMascotas(deserealizarFotoDeJson(data));

        return mascotasResponse;
    }

    private ArrayList<Mascotas> deserealizarFotoDeJson(JsonObject mascotasResponseData){

        ArrayList<Mascotas> mascotas = new ArrayList<>();

        nombreCompleto = mascotasResponseData.get(JsonKeys.USER_FULLNAME).getAsString();
        urlFoto = mascotasResponseData.get(JsonKeys.PROFILE_PICTURE).getAsString();

        Mascotas profile = new Mascotas();
        profile.setNombreCompleto(nombreCompleto);
        mascotas.add(profile);

        return mascotas;
    }
}
