package com.example.loadgithubprofilesinarecyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvName;
    private TextView mTvLogin;

    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvName = itemView.findViewById(R.id.tvName);
        mTvLogin = itemView.findViewById(R.id.tvLogin);
    }

    public void setData(ResponseDTO responseModel) {
        mTvName.setText(responseModel.getFullName());
        mTvLogin.setText(responseModel.getName());
    }
}