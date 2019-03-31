package com.nhh.wallpaper.activity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nhh.wallpaper.R;
import com.nhh.wallpaper.model.Month;

import java.io.IOException;

public class WallDetail extends AppCompatActivity {
    private ImageView imgAva;
    private TextView tvMonth, tvAuthor;
    private Button btnBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_detail);
        initView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final Month month = (Month) bundle.getSerializable("month");
        Glide.with(this).load(month.getImgMonth()).into(imgAva);
        tvMonth.setText(month.getMonthName());
        tvAuthor.setText(month.getAuthor());
        initAnimation();

        btnBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setResource(month.getImgMonth());
                    Toast.makeText(WallDetail.this,"Success",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void initAnimation() { // Explode and Slide animation
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(500);
            getWindow().setEnterTransition(explode);

            Slide slide = new Slide();
            slide.setDuration(500);
            getWindow().setReturnTransition(slide);
        }

    }

    private void initView() {
        imgAva = findViewById(R.id.img_wallpaperdetail);
        tvMonth = findViewById(R.id.tv_monthdetail);
        tvAuthor = findViewById(R.id.tv_authordetail);
        btnBackground = findViewById(R.id.btn_background);

    }
}
