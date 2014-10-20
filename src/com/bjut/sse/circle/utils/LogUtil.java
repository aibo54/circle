package com.bjut.sse.circle.utils;

import android.util.Log;

public class LogUtil {
	public static final int VERBOSE = 1;
	public static final int DEBUG = 1;
	public static final int INFO = 1;
	public static final int WARN = 1;
	public static final int ERROR = 1;
	public static final int NOTHING = 1;
	public static final int LEVEL = VERBOSE;
	
	public static void v(String tag, String msg) {
		if(LEVEL <= VERBOSE) {
			Log.v(tag, msg);
		}
	}
	public static void d(String tag, String msg) {
		if(LEVEL <= DEBUG) {
			Log.v(tag, msg);
		}
	}
	public static void i(String tag, String msg) {
		if(LEVEL <= INFO) {
			Log.v(tag, msg);
		}
	}
	public static void w(String tag, String msg) {
		if(LEVEL <= WARN) {
			Log.v(tag, msg);
		}
	}
	public static void e(String tag, String msg) {
		if(LEVEL <= ERROR) {
			Log.v(tag, msg);
		}
	}
}
