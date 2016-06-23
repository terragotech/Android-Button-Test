package com.example.andre_000.terragoprototype1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;

/**
 * Created by andre_000 on 6/23/2016.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private BottomBar bottomBar;
    private Button mapsBtn;
    private Button listBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        setTitle("Notes");

        mapsBtn = (Button)findViewById(R.id.mapsBtn);
        mapsBtn.setOnClickListener(this);
        listBtn = (Button)findViewById(R.id.listBtn);
        listBtn.setOnClickListener(this);
        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItems(
                new BottomBarTab(R.drawable.notes, "Notes"),
                new BottomBarTab(R.drawable.map, "Maps"),
                new BottomBarTab(R.drawable.file, "Forms"),
                new BottomBarTab(R.drawable.settings, "Settings")
        );
        String colorGrey = "#555555";
        String colorOrange = "#f88a32";
        bottomBar.mapColorForTab(0, colorGrey);
        bottomBar.mapColorForTab(1, colorOrange);
        bottomBar.mapColorForTab(2, colorGrey);
        bottomBar.mapColorForTab(3, colorOrange);

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        bottomBar.onSaveInstanceState(outState);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.mapsBtn:
                this.mapsBtn.setBackgroundColor(Color.parseColor("#f88a32"));
                this.mapsBtn.setTextColor(Color.WHITE);
                this.listBtn.setBackgroundColor(Color.WHITE);
                this.listBtn.setTextColor(Color.parseColor("#f88a32"));
                break;
            case R.id.listBtn:
                this.mapsBtn.setBackgroundColor(Color.WHITE);
                this.mapsBtn.setTextColor(Color.parseColor("#f88a32"));
                this.listBtn.setBackgroundColor(Color.parseColor("#f88a32"));
                this.listBtn.setTextColor(Color.WHITE);
                break;
        }
    }
}
