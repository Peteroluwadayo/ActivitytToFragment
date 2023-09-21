package com.example.activityttofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText weight,height;
    Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // i will create object from fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //creating object from fragment transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MyFirstFragment myFirstFragment = new MyFirstFragment();

        //match conpotent with  ids

        weight = findViewById(R.id.editTextWeight);
        height = findViewById(R.id.editTextHeight);
        calculate = findViewById(R.id.buttonCalculate);

       calculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Bundle bundle = new Bundle();
               int userWeight = Integer.valueOf(height.getText().toString());
               int userHeight = Integer.valueOf(height.getText().toString());

               bundle.putInt("weight",userWeight);
               bundle.putInt("height",userHeight);

               myFirstFragment.setArguments(bundle);
               fragmentTransaction.add(R.id.frame,myFirstFragment);
               fragmentTransaction.commit();
           }
       });
    }
}