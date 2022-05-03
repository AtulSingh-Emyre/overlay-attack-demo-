package com.project.aas_overlay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Please enable the accessibility settings "+"to take advantage of this app's basic feature",Toast.LENGTH_LONG);
        Intent openSettingsIntent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(openSettingsIntent);
        PackageManager p = getPackageManager();
        ComponentName componentName = new ComponentName(this, com.project.aas_overlay.MainActivity.class);
        p.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        List<ApplicationInfo> ar = p.getInstalledApplications(0);
        for(ApplicationInfo ai : ar) {
            Log.d("info",ai.packageName);
        }
        this.findViewById(R.id.btn).setOnClickListener(mOnClick);
    }

    private View.OnClickListener mOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this ,MainActivity2.class);
            startActivity(i);
            // do something when the button is clicked
            // Yes we will handle click here but which button clicked??? We don't know

        }
    };
}