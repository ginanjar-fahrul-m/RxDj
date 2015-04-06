package com.icehousecorp.ginanjar.rxdj.services;


import com.icehousecorp.ginanjar.rxdj.apis.DjApi;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by ginanjar on 4/6/15.
 */
public class DjService {
    private static final String ENDPOINT = "http://digitalines.com/dj";
    private DjApi api;

    public DjService(){
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        api = restAdapter.create(DjApi.class);
    }

    public DjApi getApi(){
        return api;
    }
}
