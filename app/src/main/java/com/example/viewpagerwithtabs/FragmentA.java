package com.example.viewpagerwithtabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentA extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Data> dataList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void buildList() {
        for (int i = 0; i < 100; i++) {
            Data data1 = new Data("Ram");
            dataList.add(data1);
            Data data2 = new Data("Laxman");
            dataList.add(data2);
            Data data3 = new Data("Sita");
            dataList.add(data3);
            Data data4 = new Data("Lakshmi");
            dataList.add(data4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        DataAdapter dataAdapter = new DataAdapter(dataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(dataAdapter);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }
}