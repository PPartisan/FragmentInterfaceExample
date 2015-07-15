package com.werdpressed.partisan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getFragmentManager().findFragmentById(R.id.fragment_container) == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, BlankFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(String message) {
        Toast.makeText(this, "onFragmentInteraction Called. Message is " + message, Toast.LENGTH_LONG).show();
    }
}
