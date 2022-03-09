package com.example.web_firebase.adpaters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class personAdapter extends FirebaseRecyclerAdapter<person, personAdapter.MyviewHolder> {

    public personAdapter(@NonNull FirebaseRecyclerOptions<person> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull personAdapter.MyviewHolder holder, int position, @NonNull person model) {

    }

    @NonNull
    @Override
    public personAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
