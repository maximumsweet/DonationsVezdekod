package com.meridius.donationsvezdekod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));
    }

    public void back(View v) {
        finish();
    }

    public void target(View v) {
        Intent intent = new Intent(this, TargetActivity.class);
        startActivity(intent);
    }

    public void regular(View v) {
        Intent intent = new Intent(this, RegularActivity.class);
        startActivity(intent);
    }
}