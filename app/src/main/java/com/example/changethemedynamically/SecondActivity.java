package com.example.changethemedynamically;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    ImageView backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String themeName = sharedPreferences.getString("theme", "");
        if (themeName.equalsIgnoreCase("Blue Theme"))
        {
            setTheme(R.style.BlueTheme);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.view_color_theme1));
            }
        }
        else if (themeName.equalsIgnoreCase("Pink Theme"))
        {
            setTheme(R.style.PinkTheme);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.view_color_theme2));
            }
        }

        else if (themeName.equalsIgnoreCase("Red Theme"))
        {
            setTheme(R.style.RedTheme);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.view_color_theme3));
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        backImg = findViewById(R.id.backImg);
        backImg.setOnClickListener(view ->
        {
            finish();
        });

    }
}