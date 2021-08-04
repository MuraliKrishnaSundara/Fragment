package com.example.events;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TimeAndDateFragment extends Fragment {

    private Button mBtnNext;
    private EditText mEtEventStartDate;
    private EditText mEtEventEndDate;
    private EditText mEtEventStartTime;
    private EditText mEtEventEndTime;
    private CL2 listener2;
    private String title;
    private String description;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("title");
            description = getArguments().getString("description");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //listener = (CommunicationListener) context;
    }

    private void initViews(View view) {
        mBtnNext = view.findViewById(R.id.btnNext);
        mEtEventStartDate = view.findViewById(R.id.etEventStartDate);
        mEtEventEndDate = view.findViewById(R.id.etEventEndDate);
        mEtEventStartTime = view.findViewById(R.id.etEventStartTime);
        mEtEventEndTime = view.findViewById(R.id.etEventEndTime);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate = mEtEventStartDate.getText().toString();
                String endDate = mEtEventEndDate.getText().toString();
                String startTime = mEtEventStartTime.getText().toString();
                String endTime = mEtEventEndTime.getText().toString();
                Bundle bundle2 = new Bundle();
                bundle2.putString("startDate", startDate);
                bundle2.putString("endDate", endDate);
                bundle2.putString("startTime", startTime);
                bundle2.putString("endTime", endTime);
                if (listener2 != null) {
                    listener2.launchPriceFragment(bundle2);
                }
            }
        });
    }

    public void setCommunicationListener2(CL2 listener) {
        this.listener2 = listener;
    }
}