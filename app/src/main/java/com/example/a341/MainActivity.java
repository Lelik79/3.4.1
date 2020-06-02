package com.example.a341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner mLanguageSpinner;
    private Spinner mColorsSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);

        mLanguageSpinner = findViewById(R.id.languageSpinner);
        mColorsSpinner = findViewById(R.id.colorsSpinner);
    }

    @Override
    public void onClick(View v) {

        switch (mColorsSpinner.getSelectedItem().toString()) {
            case "Чёрный":
            case "Black":
                Utils.changeToTheme(this, Utils.THEME_BLACK);
                break;
            case "Зелёный":
            case "Green":
                Utils.changeToTheme(this, Utils.THEME_GREEN);
                break;
            case "Синий":
            case "Blue":
                Utils.changeToTheme(this, Utils.THEME_BLUE);
                break;
            default:
                Utils.changeToTheme(this, Utils.THEME_DEFAULT);
                break;
        }

        Toast.makeText(MainActivity.this, mLanguageSpinner.getSelectedItem().toString() + " " + mColorsSpinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
        Locale locale;
        if (mLanguageSpinner.getSelectedItem().toString().equals("English")) {
            locale = new Locale("en");
        } else {
            locale = new Locale("ru");
        }
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}