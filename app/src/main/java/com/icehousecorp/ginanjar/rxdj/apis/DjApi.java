package com.icehousecorp.ginanjar.rxdj.apis;

import com.icehousecorp.ginanjar.rxdj.models.Collections;

import java.util.List;

import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by ginanjar on 4/6/15.
 */
public interface DjApi {
    @GET("/collections")
    public Observable<List<Collections>>
    getCollections();

    @POST("/collections")
    public Observable<Collections>
    addCollections(Collections collections);

    @PUT("/collections/{id}")
    public Observable<Collections>
    updateName(@Path("id") String id, String name);

    @PUT("/collections/{id}")
    public Observable<Collections>
    updateSong(@Path("id") String id, String song);

    @DELETE("/collections/{id}")
    public Observable<Collections>
    deleteCollections(@Path("id") String id);
}