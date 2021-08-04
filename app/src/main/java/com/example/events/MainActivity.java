package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationListener , CL2 {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchStudentPersonalDetailsFragment();
    }

    private void launchStudentPersonalDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();
        eventDetailsFragment.setCommunicationListener(this);
        fragmentTransaction.add(R.id.container, eventDetailsFragment, "personal").commit();
    }

    @Override
    public void launchTimeFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeAndDateFragment timeAndDateFragment = new TimeAndDateFragment();
        timeAndDateFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, timeAndDateFragment, "timeAndDateFragment").addToBackStack("").commit();
    }

    @Override
    public void launchPriceFragment(Bundle bundle2) {
        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
        priceDetailsFragment.setArguments(bundle2);
        fragmentTransaction2.replace(R.id.container, priceDetailsFragment, "priceDetailsFragment").addToBackStack("a").commit();
    }
}