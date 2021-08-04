package com.example.loadgithubprofilesinarecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubFragment extends Fragment {

    private RecyclerView recyclerView;
    private EditText mEtAccountId;
    private Button mBtnFetch;
    private List<ResponseDTO> profileModelList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_git_hub, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        String postId = mEtAccountId.getText().toString();
        apiService.getPosts(postId).enqueue(new Callback<List<ResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ResponseDTO>> call, Response<List<ResponseDTO>> response) {
                profileModelList = response.body();
                setRecyclerView();
            }

            @Override
            public void onFailure(Call<List<ResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        ProfileAdapter animalAdapter = new ProfileAdapter(profileModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(animalAdapter);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        mEtAccountId = view.findViewById(R.id.etAccountId);
        mBtnFetch = view.findViewById(R.id.requestAPI);
        mBtnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }
}