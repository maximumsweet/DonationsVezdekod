package com.meridius.donationsvezdekod;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TargetActivity extends AppCompatActivity {

    private static final int SELECT_PICTURE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));
    }

    public void back(View v) {
        finish();
    }

    public void next(View v) {
        Intent intent = new Intent(this, MoreActivity.class);
        startActivity(intent);
    }

    public void uploadPic(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Выберите изображение"), SELECT_PICTURE);
    }

    public void removePic(View v) {
        findViewById(R.id.selectPic).setVisibility(View.VISIBLE);
        findViewById(R.id.pictureCard).setVisibility(View.GONE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    findViewById(R.id.selectPic).setVisibility(View.GONE);
                    findViewById(R.id.pictureCard).setVisibility(View.VISIBLE);
                    ImageView picture = (ImageView) findViewById(R.id.picture);
                    picture.setImageURI(selectedImageUri);
                    picture.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            }
        }
    }
}