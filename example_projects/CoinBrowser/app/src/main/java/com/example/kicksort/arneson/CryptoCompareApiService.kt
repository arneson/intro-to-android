package com.example.kicksort.arneson

import io.reactivex.Observable
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET



/**
 * Created by kicksort on 2017-12-22.
 */
interface CryptoCompareApiService {

    @GET("coinlist")
    fun getCurrencies(): Observable<Result>

    /**
     * Factory class for convenient creation of the Api Service interface
     */
    object Factory {

        fun create(): CryptoCompareApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://www.cryptocompare.com/api/data/")
                    .build()

            return retrofit.create(CryptoCompareApiService::class.java)
        }
    }
}