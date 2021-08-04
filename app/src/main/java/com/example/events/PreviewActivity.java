package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private TextView mTvDescription;
    private TextView mTvStartDate;
    private TextView mTvEndDate;
    private TextView mTvStartTime;
    private TextView mTvEndTime;
    private TextView mTvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        EventModel model = (EventModel) getIntent().getSerializableExtra("model");
        mTvTitle.setText(model.getEventTitle());
        mTvDescription.setText(model.getEventDescription());
        mTvStartDate.setText(model.getEventStartDate());
        mTvEndDate.setText(model.getEventEndDate());
        mTvStartTime.setText(model.getEventStartTime());
        mTvEndTime.setText(model.getEventEndTime());
        mTvPrice.setText(model.getPrice() + " ");
    }

    private void initViews() {
        mTvTitle = findViewById(R.id.tvEventTitle);
        mTvDescription = findViewById(R.id.tvEventDescription);
        mTvStartDate = findViewById(R.id.tvEventStartDate);
        mTvEndDate = findViewById(R.id.tvEventEndDate);
        mTvStartTime = findViewById(R.id.tvEventStartTime);
        mTvEndTime = findViewById(R.id.tvEventEndTime);
        mTvPrice = findViewById(R.id.tvPrice);
    }
}