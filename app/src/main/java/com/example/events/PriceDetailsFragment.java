package com.example.events;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PriceDetailsFragment extends Fragment {

    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private EditText mEtCurrency;
    private EditText mEtPrice;
    private Button mBtnPreview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("title");
            description = getArguments().getString("description");
            startDate = getArguments().getString("startDate");
            endDate = getArguments().getString("endDate");
            startTime = getArguments().getString("startTime");
            endTime = getArguments().getString("endTime");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtCurrency = view.findViewById(R.id.etCurrency);
        mEtPrice = view.findViewById(R.id.etPrice);
        mBtnPreview = view.findViewById(R.id.btnPreview);
        mBtnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currency = mEtCurrency.getText().toString();
                int price = Integer.parseInt(mEtPrice.getText().toString());
                EventModel model = new EventModel(title, description, startDate, endDate, startTime, endTime, price);
                Intent intent = new Intent(getContext(), PreviewActivity.class);
                intent.putExtra("model", model);
                startActivity(intent);
            }
        });
    }
}