package com.devies.simonarneson.navigationexample;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GreetingFragment extends android.support.v4.app.Fragment {


    private String nameToGreet = "";

    public GreetingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_greeting, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();

        nameToGreet = arguments.getString("name");
    }

    @Override
    public void onStart() {
        super.onStart();

        ((TextView)getView().findViewById(R.id.myAmazingTextView)).setText(nameToGreet);
    }
}
