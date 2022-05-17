package com.rizal.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rizal.utsa.ticketbox.model.Konser;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemKonser extends AppCompatActivity {

    private ImageView imgBand;
    private TextView txtTglKonser, txtKotaKonser, txtHargaKonser;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
    private Locale myIndonesianLocale = new Locale("in", "ID");
    private NumberFormat formater = NumberFormat.getCurrencyInstance(myIndonesianLocale);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_konser);
        Konser konser = getIntent().getParcelableExtra("KONSER");
        imgBand = (ImageView) findViewById(R.id.imgBand);
        txtTglKonser = (TextView) findViewById(R.id.txtTglKonser);
        txtKotaKonser = (TextView) findViewById(R.id.txtKotaKonser);
        txtHargaKonser = (TextView) findViewById(R.id.txtHargaKonser);
        imgBand.setImageResource(konser.getImgCoverBand());
        for (LocalDateTime tgl: konser.getDateKonser()) {
            txtTglKonser.setText(txtTglKonser.getText() + tgl.format(formatter) + "\n");
        };
        StringBuilder stringKota = new StringBuilder();
        for (String kota: konser.getKotaKonser()) {
            stringKota.append(kota).append(", ");
        }
        txtKotaKonser.setText(stringKota.deleteCharAt(stringKota.length() - 1).deleteCharAt(stringKota.length() - 1).toString());
        txtHargaKonser.setText(formater.format(konser.getHargaKonser()));



    }
}