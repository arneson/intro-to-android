package com.example.kicksort.arneson

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var layoutManager: GridLayoutManager

    private lateinit var myList: RecyclerView
    private var currencies = mutableListOf<Currency>()

    private var api = CryptoCompareApiService.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myList =  my_list

        layoutManager = GridLayoutManager(this, 3)

        myList.layoutManager = layoutManager


        myList.adapter = NameListAdapter(currencies)

        api.getCurrencies().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map { result -> result.Data.values }.subscribe { currency ->
            currencies.clear()
            currencies.addAll(currency)
            myList.adapter.notifyDataSetChanged()
        }

    }
}
