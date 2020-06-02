package com.example.a341;

import android.app.Activity;
import android.content.Intent;

public class Utils {

    private static int sTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_BLACK = 1;
    public final static int THEME_GREEN = 2;
    public final static int THEME_BLUE = 3;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_BLACK:
                activity.setTheme(R.style.Black);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.Green);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.Blue);
                break;
        }
    }
}