package com.crossbowffs.quotelock.utils;

import android.util.Log;

public final class Xlog {
    private static final int LOG_LEVEL = Log.VERBOSE;
    private static final boolean MERGE_TAGS = true;
    private static final String APPLICATION_TAG = "QuoteLock";

    private Xlog() { }

    private static void log(int priority, String tag, String message, Object... args) {
        if (priority < LOG_LEVEL) {
            return;
        }

        if (MERGE_TAGS) {
            tag = APPLICATION_TAG;
        }

        message = String.format(message, args);
        if (args.length > 0 && args[args.length - 1] instanceof Throwable) {
            Throwable throwable = (Throwable)args[args.length - 1];
            String stacktraceStr = Log.getStackTraceString(throwable);
            message = message + '\n' + stacktraceStr;
        }

        Log.println(priority, tag, message);
    }

    public static void v(String tag, String message, Object... args) {
        log(Log.VERBOSE, tag, message, args);
    }

    public static void d(String tag, String message, Object... args) {
        log(Log.DEBUG, tag, message, args);
    }

    public static void i(String tag, String message, Object... args) {
        log(Log.INFO, tag, message, args);
    }

    public static void w(String tag, String message, Object... args) {
        log(Log.WARN, tag, message, args);
    }

    public static void e(String tag, String message, Object... args) {
        log(Log.ERROR, tag, message, args);
    }
}
