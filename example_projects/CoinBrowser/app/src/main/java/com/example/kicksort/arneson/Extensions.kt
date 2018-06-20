    package com.example.kicksort.arneson

    import android.support.annotation.LayoutRes
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup

    /**
     * Created by kicksort on 2017-12-22.
     */


    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }