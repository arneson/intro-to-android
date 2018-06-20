package com.devies.simonarneson.recyclingexample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> names = new ArrayList<>();

    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        names.add("Simon");
        names.add("Erik");

        for(int i = 0; i<100000; i++) {
        }
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        myRecyclerView = findViewById(R.id.myListView);

        myRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        RecyclerView.Adapter<NameHolder> myAdapter = new RecyclerView.Adapter<NameHolder>() {
            @NonNull
            @Override
            public NameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_list_item,parent,false);

                return new NameHolder(v);
            }

            @Override
            public void onBindViewHolder(@NonNull NameHolder holder, int position) {
                holder.textView.setText(names.get(position));
            }

            @Override
            public int getItemCount() {
                return names.size();
            }
        };

        myRecyclerView.setAdapter(myAdapter);

        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names.add("Super generic name "+ Math.floor(Math.random() * 10000));
            }
        });

    }

    class NameHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public NameHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.myTextView);
        }
    }
}
