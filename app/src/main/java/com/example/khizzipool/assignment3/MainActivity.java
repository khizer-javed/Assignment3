package com.example.khizzipool.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void task1 (View view)
    {
        Intent i = new Intent(MainActivity.this,Task1.class);
        startActivity(i);
    }

    public void task2 (View view)
    {
        Intent i = new Intent(MainActivity.this,Task2.class);
        startActivity(i);
    }
}
