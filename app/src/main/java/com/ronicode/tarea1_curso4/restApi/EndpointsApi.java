package com.ronicode.tarea1_curso4.restApi;

import com.ronicode.tarea1_curso4.restApi.model.MascotasResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Roni on 26/05/2017.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_FOLOWS_MEDIA_RECENT)
    Call<MascotasResponse> getRecentMedia(@Path("user-id") String id);

    @GET(ConstantesRestApi.URL_GET_PROFILE_USER_WITH_ID)
    Call<MascotasResponse> getProfile(@Path("user-id") String id);

    @GET(ConstantesRestApi.URL_GET_FOLLOWS)
    Call<MascotasResponse> getFollows();

    @GET(ConstantesRestApi.URL_GET_FOLOWS_MEDIA_RECENT)
    Call<MascotasResponse> getFollowsMediaRecent(@Path("user-id") String id);
}
