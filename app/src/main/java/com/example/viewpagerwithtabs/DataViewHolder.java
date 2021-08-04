package com.example.viewpagerwithtabs;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvData;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    private void initViews() {
        mTvData = itemView.findViewById(R.id.tvData);
    }

    public void setData(Data data) {
        mTvData.setText(data.getData());
    }
}