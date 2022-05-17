package com.rizal.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView txtNamaAplikasi,txtVersiAplikasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        txtNamaAplikasi = (TextView) findViewById(R.id.txtNamaAplikasi);
        txtVersiAplikasi = (TextView) findViewById(R.id.txtVersiAplikasi);
        txtNamaAplikasi.setText(getBaseContext().getApplicationInfo().loadLabel(getBaseContext().getPackageManager()).toString());
        String versi = "";
        try {
            versi = getBaseContext().getPackageManager().getPackageInfo(getBaseContext().getPackageName(), 0).versionName;
        }catch (Exception e) {
            Log.d("Error", e.toString());
        }
        txtVersiAplikasi.setText(versi);
    }
}