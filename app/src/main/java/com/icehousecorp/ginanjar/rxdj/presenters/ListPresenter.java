package com.icehousecorp.ginanjar.rxdj.presenters;

import com.icehousecorp.ginanjar.rxdj.MainActivity;
import com.icehousecorp.ginanjar.rxdj.models.Collections;
import com.icehousecorp.ginanjar.rxdj.services.DjService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ginanjar on 4/6/15.
 */
public class ListPresenter {
    MainActivity view;
    DjService service;

    public ListPresenter(MainActivity v, DjService s){
        view = v;
        service = s;
    }

    public void loadSongs(){
        service.getApi()
                .getCollections()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(collections -> view.displaySongs(collections));

                /*
                .subscribe(new Observer<List<Collections>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Collections> collections) {
                        view.displaySongs(collections);
                    }
                });
                */
    }
}
