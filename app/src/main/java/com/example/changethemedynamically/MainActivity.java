package com.example.changethemedynamically;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.changethemedynamically.ThemePreferenceActivity.RESULT_CODE_THEME_UPDATED;

public class MainActivity extends AppCompatActivity {

    private int SETTING_ACTION = 1;
    TextView tvChangeTheme;
    Button bt;

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
        setContentView(R.layout.activity_main);

        tvChangeTheme = findViewById(R.id.themechange);
        bt = findViewById(R.id.bt);
        tvChangeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, ThemePreferenceActivity.class), SETTING_ACTION);
            }
        });
        bt.setOnClickListener(view ->
        {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == SETTING_ACTION)
        {
            if (requestCode == RESULT_CODE_THEME_UPDATED)
            {
               // finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                return;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}