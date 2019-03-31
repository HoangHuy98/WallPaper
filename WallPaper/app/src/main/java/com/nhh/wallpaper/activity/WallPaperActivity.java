package com.nhh.wallpaper.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

import com.nhh.wallpaper.R;
import com.nhh.wallpaper.adapter.WallpaperAdapter;
import com.nhh.wallpaper.listener.ItemClick;
import com.nhh.wallpaper.model.Month;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WallPaperActivity extends AppCompatActivity implements ItemClick {
    private RecyclerView rvWallPaper;
    private List<Month> arrMonth;
    private WallpaperAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_paper);

        rvWallPaper = findViewById(R.id.recycle_view);

        arrMonth = new ArrayList<>();
        arrMonth.add(new Month(R.drawable.january, "January"));
        createMonth();

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvWallPaper.setLayoutManager(layoutManager);

        adapter = new WallpaperAdapter(arrMonth, this, this);
        rvWallPaper.setAdapter(adapter);

    }

    private void createMonth() {
        arrMonth.add(new Month(R.drawable.february, "February"));
        arrMonth.add(new Month(R.drawable.march, "March"));
        arrMonth.add(new Month(R.drawable.april, "April"));
        arrMonth.add(new Month(R.drawable.may, "May"));
        arrMonth.add(new Month(R.drawable.june, "June"));
        arrMonth.add(new Month(R.drawable.july, "July"));
        arrMonth.add(new Month(R.drawable.august, "August"));
        arrMonth.add(new Month(R.drawable.september, "September"));
        arrMonth.add(new Month(R.drawable.october, "October"));
        arrMonth.add(new Month(R.drawable.november, "November"));
        arrMonth.add(new Month(R.drawable.december, "December"));

    }


    @Override
    public void onClick(int position, View view) {
        Month month = arrMonth.get(position);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this); // Set Scene can transition

            Intent intent = new Intent(WallPaperActivity.this, WallDetail.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("month", month);

            intent.putExtras(bundle);
            startActivity(intent, options.toBundle());
        }
    }


}
