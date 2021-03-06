package com.lzx.nicemusic.module.main.presenter;

import android.annotation.SuppressLint;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jakewharton.rxbinding2.view.RxView;
import com.lzx.musiclibrary.aidl.model.SongInfo;
import com.lzx.nicemusic.helper.DataHelper;
import com.lzx.nicemusic.network.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by xian on 2018/1/14.
 */

public class MainModel {

    /**
     * 1、新歌榜，2、热歌榜，11、摇滚榜，12、爵士，16、流行，
     * 21、欧美金曲榜，22、经典老歌榜，23、情歌对唱榜，
     * 24、影视金曲榜，25、网络歌曲榜
     *
     * @return
     */
    @SuppressLint("CheckResult")
    public Observable<List<SongInfo>> loadMainData() {
        List<SongInfo> infoList = new ArrayList<>();
        return RetrofitHelper.getMusicApi().requestMusicList(1, 4, 0)
                .flatMap(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    return RetrofitHelper.getMusicApi().requestMusicList(2, 4, 0);
                })
                .flatMap(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    return RetrofitHelper.getMusicApi().requestMusicList(11, 4, 0);
                })
                .flatMap(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    return RetrofitHelper.getMusicApi().requestMusicList(12, 4, 0);
                })
                .flatMap(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    return RetrofitHelper.getMusicApi().requestMusicList(16, 4, 0);
                })
                .flatMap(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    return RetrofitHelper.getMusicApi().requestMusicList(21, 4, 0);
                })
                .flatMap(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    return RetrofitHelper.getMusicApi().requestMusicList(22, 4, 0);
                })
                .flatMap(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    return RetrofitHelper.getMusicApi().requestMusicList(23, 4, 0);
                })
                .flatMap(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    return RetrofitHelper.getMusicApi().requestMusicList(24, 4, 0);
                })
                .flatMap(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    return RetrofitHelper.getMusicApi().requestMusicList(25, 4, 0);
                })
                .map(responseBody -> {
                    infoList.addAll(DataHelper.fetchJSONFromUrl(responseBody));
                    String json = new Gson().toJson(infoList);
                    //  CacheManager.getImpl().saveCache(CacheManager.KEY_HOME_LIST_DATA, json);
                    return infoList;
                });
    }

    @SuppressLint("CheckResult")
    public void dd(){
        Observable.create(new ObservableOnSubscribe<SongInfo>() {
            @Override
            public void subscribe(ObservableEmitter<SongInfo> emitter) throws Exception {
                emitter.onNext(new SongInfo());
            }
        }).subscribe(new Consumer<SongInfo>() {
            @Override
            public void accept(SongInfo songInfo) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });



    }


}
