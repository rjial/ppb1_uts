package com.rizal.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rizal.utsa.ticketbox.model.Konser;
import com.rizal.utsa.ticketbox.model.Tiket;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

public class FinalTiket extends AppCompatActivity {

    private Locale myIndonesianLocale = new Locale("in", "ID");
    private NumberFormat formater = NumberFormat.getCurrencyInstance(myIndonesianLocale);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
    private TextView txtTotalBayar, txtJenisPembayaranFinal, txtTanggalBayar, txtNoAC, txtAtasNamaFinal,txtNamaKKFinal, txtAtasNamaKKFinal, txtJmlhByrKKFinal, txtTglBayarKKFinal, txtNoIDFinal, txtJenisIDFinal, txtNamaDiriFinal, txtEmailDiriFinal, txtAlamatDiriFinal;
    private LinearLayout lytTFBankFinal,lytKonserFinal, lytKKFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_tiket);
        txtTotalBayar = (TextView) findViewById(R.id.txtTotalBayar);
        txtJenisPembayaranFinal = (TextView) findViewById(R.id.txtJenisPembayaranFinal);
        txtTanggalBayar = (TextView) findViewById(R.id.txtTanggalBayar);
        txtNoAC = (TextView) findViewById(R.id.txtNoAC);
        txtAtasNamaFinal = (TextView) findViewById(R.id.txtAtasNamaFinal);
        txtNamaKKFinal = (TextView) findViewById(R.id.txtNamaKKFinal);
        txtAtasNamaKKFinal = (TextView) findViewById(R.id.txtAtasNamaKKFinal);
        txtJmlhByrKKFinal = (TextView) findViewById(R.id.txtJmlhByrKKFinal);
        txtTglBayarKKFinal = (TextView) findViewById(R.id.txtTglBayarKKFinal);
        txtNoIDFinal = (TextView) findViewById(R.id.txtNoIDFinal);
        txtJenisIDFinal = (TextView) findViewById(R.id.txtJenisIDFinal);
        txtNamaDiriFinal = (TextView) findViewById(R.id.txtNamaDiriFinal);
        txtEmailDiriFinal = (TextView) findViewById(R.id.txtEmailDiriFinal);
        txtAlamatDiriFinal = (TextView) findViewById(R.id.txtAlamatDiriFinal);
        lytTFBankFinal = (LinearLayout) findViewById(R.id.lytTFBankFinal);
        lytKonserFinal = (LinearLayout) findViewById(R.id.lytKonserFinal);
        lytKKFinal = (LinearLayout) findViewById(R.id.lytKKFinal);
        Intent intent = getIntent();
        Tiket tiket = intent.getParcelableExtra("TIKET");
        txtTotalBayar.setText(formater.format(tiket.calcHarga()));
        if (tiket.getPembayaranPembeli().equals(Tiket.Pembayaran.TRANSFER_BANK)) {
            txtJenisPembayaranFinal.setText(R.string.transfer_bank);
            lytTFBankFinal.setVisibility(View.VISIBLE);
            lytKKFinal.setVisibility(View.GONE);
            txtTanggalBayar.setText(formatter.format(tiket.getTglTransfer()));
            txtNoAC.setText(tiket.getNoAC());
            txtAtasNamaFinal.setText(tiket.getNamaPembayar());
        } else if(tiket.getPembayaranPembeli().equals(Tiket.Pembayaran.KARTU_KREDIT)) {
            txtJenisPembayaranFinal.setText(R.string.kartu_kredit);
            lytTFBankFinal.setVisibility(View.GONE);
            lytKKFinal.setVisibility(View.VISIBLE);
            txtNamaKKFinal.setText(tiket.getNamaKK());
            txtAtasNamaKKFinal.setText(tiket.getAtasNamaKK());
            txtJmlhByrKKFinal.setText(formater.format(tiket.getJmlhBayarKK()));
            txtTglBayarKKFinal.setText(formatter.format(tiket.getTglBayarKK()));
        }
        txtNoIDFinal.setText(tiket.getNoID());
        txtJenisIDFinal.setText(tiket.getJenisID());
        txtNamaDiriFinal.setText(tiket.getNamaPembeli());
        txtEmailDiriFinal.setText(tiket.getEmailPembeli());
        txtAlamatDiriFinal.setText(tiket.getAlamatPembeli());
        for (Map.Entry<Konser, Integer> mapEntry: tiket.getListKonser().entrySet()) {
            Konser konser = mapEntry.getKey();
            int qty = mapEntry.getValue();
            View child = getLayoutInflater().inflate(R.layout.layout_tiket,null);
            lytKonserFinal.addView(child);
            TextView txtNamaKonserTiket = (TextView) child.findViewById(R.id.txtNamaKonserTiket);
            TextView txtDeskripsiTiket = (TextView) child.findViewById(R.id.txtDeskripsiTiket);
            TextView txtTotalTiket = (TextView) child.findViewById(R.id.txtTotalTiket);
            txtNamaKonserTiket.setText(konser.getNamaKonser());
            txtDeskripsiTiket.setText(formater.format(konser.getHargaKonser()) + " (qty : " + String.valueOf(qty) + ")");
            txtTotalTiket.setText(formater.format(konser.getHargaKonser() * qty));
        }
    }
}