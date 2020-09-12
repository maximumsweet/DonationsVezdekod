package com.meridius.donationsvezdekod;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class MoreActivity extends AppCompatActivity {

    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));

        findViewById(R.id.inSum).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findViewById(R.id.dateText).setVisibility(View.GONE);
                    }
                }
        );
        findViewById(R.id.inDate).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findViewById(R.id.dateText).setVisibility(View.VISIBLE);
                    }
                }
        );
    }

    public void back(View v) {
        finish();
    }

    public void next(View v) {
        Intent intent = new Intent(this, FinalActivity.class);
        startActivity(intent);
    }

    public void changeDate(View v) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        EditText et = (EditText) findViewById(R.id.dateText);
                        et.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}