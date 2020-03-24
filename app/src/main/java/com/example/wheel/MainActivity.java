package com.example.wheel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    Wheel wheel;
    EditText progressEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheel = findViewById(R.id.wheel);
        progressEt = findViewById(R.id.progressEt);
    }

    public void animate(View view) {
        wheel.move(parseInt(progressEt.getText().toString()));
    }
}
