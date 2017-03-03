package com.example.acer.myobserble;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class MainActivity extends AppCompatActivity {
//    Serv serv;
//    ServiceConnection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final Integer a =1;
        String s = "hello";

//        final String s = "Asd";
//        Intent intent = new Intent(this,Serv.class);
//        startService(intent);

//        connection = new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName name, IBinder service) {
//                serv= ((Serv.MyBinder) service).getMyServ();
//            }
//
//            @Override
//            public void onServiceDisconnected(ComponentName name) {
//
//            }
//        };
//        bindService(intent,connection,BIND_AUTO_CREATE);
//        Observable<Integer> observable = Observable.create(
//                new ObservableOnSubscribe<Integer>(){
//
//                    @Override
//                    public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                        e.onNext(a);
//                    }
//                }
//
//        );
//        Observable<String> observable =     Observable.just(s);
//        Observer<Integer> observer= new Observer<Integer>() {
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer s) {
//                Log.i("===",s+"");
//            }
//        };
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i<10; i ++){
//            list.add(i,s+i);
//
//        }
//        Observable<String> observable=Observable.fromIterable(list);
//
//        Observer<String> observer =new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.i("===",s+"");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };

//        Observable<Integer> observable=Observable.just("hello").map(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) throws Exception {
//                return s.length();
//            }
//        }) ;
//        Observer<Integer> observer= new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer s) {
//            Log.i("===",s+"");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        Observable<Integer> observable=Observable.just("hello").map(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) throws Exception {
//                return s.length();
//            }
//        }) ;
//        Observer<Integer> observer= new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer s) {
//                Log.i("===",s+"");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
        //defer模式下的
//        Observable<String> observer = Observable.defer(new Callable<ObservableSource<? extends String>>() {
//            @Override
//            public ObservableSource<? extends String> call() throws Exception {
//                return Observable.just("defer");
//            }
//        });
        //
//        Observable<Long > observable = Observable.interval(2, TimeUnit.SECONDS);
//        Observable<Integer> observable = Observable.just("hello").map(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) throws Exception {
//                return s.length();
//            }
//        });
//        Observer<Integer> observer= new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer s) {
//                Log.i("===", "dddddddddddd"+s);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };

//
//        observable.subscribe(observer);
        Retrofit retrofit = create();
        Api api = retrofit.create(Api.class);
        Observable<AllCity>observable = api.getAllcity(appkey);
        observable.subscribeOn(Schedulers.io())
                .flatMap(new Function<AllCity, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(AllCity allCity) throws Exception {
                        return ;
                    }
                })




    }
    private static Retrofit create(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout();
        builder.readTimeout();

        return new Retrofit.Builder().baseUrl()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder).build();

    }
    public interface  Api{
        @GET("citys")
        Observable<String> getAllcity(@Query("key") String key);
    }






}
