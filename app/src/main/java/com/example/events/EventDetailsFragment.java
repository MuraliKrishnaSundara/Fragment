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

public class EventDetailsFragment extends Fragment {

    private Button mBtnNext;
    private EditText mEtEventTitle;
    private EditText mEtEventDescription;
    private CommunicationListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_details, container, false);
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
        mEtEventTitle = view.findViewById(R.id.etEventTitle);
        mEtEventDescription = view.findViewById(R.id.etEventDescription);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mEtEventTitle.getText().toString();
                String description = mEtEventDescription.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("description", description);
                if (listener != null) {
                    listener.launchTimeFragment(bundle);
                }
            }
        });
    }

    public void setCommunicationListener(CommunicationListener listener) {
        this.listener = listener;
    }
}