package com.example.loadgithubprofilesinarecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {

    private List<ResponseDTO> profileModelList;

    public ProfileAdapter(List<ResponseDTO> ProfileModelList) {
        this.profileModelList = ProfileModelList;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        ResponseDTO response = profileModelList.get(position);
        holder.setData(response);
    }

    @Override
    public int getItemCount() {
        return profileModelList.size();
    }
}