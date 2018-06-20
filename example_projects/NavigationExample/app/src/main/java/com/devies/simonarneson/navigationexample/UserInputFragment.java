package com.devies.simonarneson.navigationexample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserInputFragment extends Fragment {


    private Button bt;
    public UserInputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_input, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bt = getView().findViewById(R.id.myAmazingButton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                GreetingFragment nextFragment = new GreetingFragment();
                Bundle arguments = new Bundle();
                arguments.putString("name", ((EditText)getView().findViewById(R.id.myAmazingEditText)).getText().toString());
                nextFragment.setArguments(arguments);
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left).replace(R.id.main_fragment, nextFragment).commit();
            }
        });
    }
}
