package com.rizal.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public LinearLayout lytItemPesanTiket, lytDaftarKonser, lytOfficialWV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lytItemPesanTiket = (LinearLayout) findViewById(R.id.lytItemPesanTiket);
        lytItemPesanTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PesanTiketKonser.class);
                startActivity(intent);
            }
        });
        lytDaftarKonser = (LinearLayout) findViewById(R.id.lytDaftarKonser);
        lytDaftarKonser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListKonser.class);
                startActivity(intent);
            }
        });
        lytOfficialWV = (LinearLayout) findViewById(R.id.lytOfficialWV);
        lytOfficialWV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OfficialKonser.class);
                startActivity(intent);
            }
        });
    }
}