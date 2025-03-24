package com.bryancandi.android.uituner;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.not_found_dialog)
                    .setPositiveButton(R.string.uninstall, (dialog, id) -> {
                        Uri packageUri = Uri.parse("package:com.bryancandi.android.uituner");
                        Intent UninstallIntent = new Intent(Intent.ACTION_DELETE, packageUri);
                        startActivity(UninstallIntent);
                        finish();
                    })
                    .setNegativeButton(R.string.cancel, (dialog, id) -> finish());
            builder.create().show();
        }
    }
}
