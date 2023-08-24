package com.bryancandi.android.uituner;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.android.systemui", "com.android.systemui.DemoMode"));
        try {
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Uri packageUri = Uri.parse("package:com.bryancandi.android.uituner");
            Intent UninstallIntent = new Intent(Intent.ACTION_DELETE, packageUri);
            startActivity(UninstallIntent);
            Toast.makeText(getApplicationContext(), getString(R.string.not_found),
                    Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
