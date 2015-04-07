package com.icehousecorp.ginanjar.rxdj.presenters;

import com.icehousecorp.ginanjar.rxdj.MainActivity;
import com.icehousecorp.ginanjar.rxdj.models.Collections;
import com.icehousecorp.ginanjar.rxdj.models.Pictures;
import com.icehousecorp.ginanjar.rxdj.services.DjService;

import java.util.List;

import rx.Observable;
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
        Observable<List<Collections>> collObservable = service.getApi()
                .getCollections()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        Observable<List<Pictures>> picObservable = service.getApi()
                .getPictures()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());


        //Chaining Observable call

        Observable.zip(collObservable, picObservable, (c, p) -> combinePics(c, p))
                .subscribe(combined -> view.displaySongs(combined));

        /*
        //Single Observable call

        service.getApi()
                .getCollections()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(collections -> view.displaySongs(collections));
         */


        /*
            // Here is RX subscription without JAVA8 syntax, it's totally the same but much longer


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

    public List<Collections> combinePics(List<Collections> collections, List<Pictures> pictures){
        /*
            Objective: changing default picture from Pictures JSON based on Collection Id(s).

            Put some algorithm here to merge Collections:
            [
                {
                    "id": "1",
                    "name": "name",
                    "song": "song",
                    "picture": "https://cdn3.iconfinder.com/data/icons/communication-icons-3/512/Headset-128.png"
                },
                {
                    "id": "2",
                    "name": "name",
                    "song": "song 1",
                    "picture": "https://cdn3.iconfinder.com/data/icons/communication-icons-3/512/Headset-128.png"
                },
                {
                    "id": "3",
                    "name": "name",
                    "song": "song 2",
                    "picture": "https://cdn3.iconfinder.com/data/icons/communication-icons-3/512/Headset-128.png"
                },
                {
                    "id": "4",
                    "name": "name",
                    "song": "song 3",
                    "picture": "https://cdn3.iconfinder.com/data/icons/communication-icons-3/512/Headset-128.png"
                }
            ]

            and Pictures:
            [
                {
                    "id": "1",
                    "url": "http://media.tumblr.com/tumblr_lnztyiRfXY"
                },
                {
                    "id": "2",
                    "url": "http://media.tumblr.com/tumblr_lnztyiRfXY"
                },
                {
                    "id": "3",
                    "url": "http://media.tumblr.com/tumblr_lnztyiRfXY"
                },
                {
                    "id": "4",
                    "url": "http://media.tumblr.com/tumblr_lnztyiRfXY"
                }
            ]
         */
        return collections;
    }
}
