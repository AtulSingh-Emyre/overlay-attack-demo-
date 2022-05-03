package com.project.aas_overlay;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class MyAccessibilityService extends AccessibilityService {
    private static final String VICTIM_APP = "com.example.victim_app";
    private static String currentVictimActivity = "";
    private static final String TAG = "Accessibility Event";

    @Override
    public void onServiceConnected() {
        Log.e(TAG,"on Service Connected triggered");
    }


    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.e(TAG, "onAccessibilityEvent Triggered");
        AccessibilityNodeInfo nodeInfo = event.getSource();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && nodeInfo ==null) {
            nodeInfo = getRootInActiveWindow();
        }
        if(event.getEventType() == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            if(event.getPackageName().toString().equals("com.google.android.gm")){

            }
            Log.i(TAG, event.getPackageName().toString());
        }
        nodeInfo.recycle();
    }

    @Override
    public void onInterrupt() {

    }
}
