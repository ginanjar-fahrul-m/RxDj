package com.icehousecorp.ginanjar.rxdj.apis;

import android.graphics.Picture;

import com.icehousecorp.ginanjar.rxdj.models.Collections;
import com.icehousecorp.ginanjar.rxdj.models.Pictures;

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

    @GET("/pictures")
    public Observable<List<Pictures>>
    getPictures();

    @POST("/collections")
    public Observable<Collections>
    addCollections(Collections collections);

    @PUT("/collections/{id}")
    public Observable<Collections>
    updateName(@Path("id") String id, String name, String picture);

    @PUT("/collections/{id}")
    public Observable<Collections>
    updateSong(@Path("id") String id, String song, String picture);

    @DELETE("/collections/{id}")
    public Observable<Collections>
    deleteCollections(@Path("id") String id);
}