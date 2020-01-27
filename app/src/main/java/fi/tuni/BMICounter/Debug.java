package fi.tuni.BMICounter;

import android.content.Context;
import android.util.Log;

public class Debug {
    public static void print(String tag, String msg, int level) {
        if(BuildConfig.DEBUG) {
            Log.d("fi.tuni.exercise2", "debug");

        }

    }

    // true == debug printed in UI
    // false == debug printed in console
    public static boolean toastDebug() {
        boolean UIdebug = false;
        return UIdebug;
    }

    public static void loadDebug(Context host) {
      int DEBUG_LEVEL = R.integer.debugLevel;
    }
}
