package com.icehousecorp.ginanjar.rxdj.util;

import rx.Observable;

/**
 * Created by ginanjar on 4/2/15.
 */
public class DjClient {
    private static final String API_URL = "http://digitalines.com/dj/";

    static class Collections {
        String id;
        String name;
        String song;
    }

    interface Dj {
        @GET("/collections")

        Observable<Collections> getCollections();
    }
}
