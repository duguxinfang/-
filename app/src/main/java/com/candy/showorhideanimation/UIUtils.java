package com.candy.showorhideanimation;

import android.content.Context;
import android.util.DisplayMetrics;


public class UIUtils {
    //===================屏幕尺寸相关======================
    private static float app_density = 0.1f;

    private static int screen_width;

    private static int screen_height;

    public static int dip2px(Context context, float dpValue) {
        if (app_density == 0.1f) {
            if (null == context) {
                return (int) dpValue;
            }
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            app_density = metrics.density;
            screen_width = metrics.widthPixels;
            screen_height = metrics.heightPixels;

        }
        return (int) (dpValue * app_density + 0.5f);
    }

    public static void initDip2px(Context context) {
        if (null != context) {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            app_density = metrics.density;
            screen_width = metrics.widthPixels;
            screen_height = metrics.heightPixels;
        }
    }

    public static int getScreenWidth() {
        return screen_width;
    }


    public static int getScreenHeight() {
        return screen_height;
    }

    public static float getDensity() {
        return app_density;
    }

    public static int getRealHeight() {
        return (int) (screen_height - app_density * 25);
    }

    public static int px2dip(int px) {
        return (int) (px / app_density + 0.5f);
    }

    public static float screenScale() {
        return ((float) screen_height) / screen_width;
    }


}
