package com.rizal.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormatSymbols;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.rizal.utsa.ticketbox.model.Konser;
import com.rizal.utsa.ticketbox.model.Tiket;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class PesanTiketKonser extends AppCompatActivity {

    private LinearLayout lytCBKonser, lytKotaKonser, lytTransferBank, lytKartuKredit;
    private TextView txtJmlhPembayaran;
    private RadioGroup rgPembayaran;
    private Locale myIndonesianLocale = new Locale("in", "ID");
    private NumberFormat formater = NumberFormat.getCurrencyInstance(myIndonesianLocale);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_tiket_konser);
        lytCBKonser = (LinearLayout) findViewById(R.id.lytCBKonser);
        lytKotaKonser = (LinearLayout) findViewById(R.id.lytKotaKonser);
        txtJmlhPembayaran = (TextView) findViewById(R.id.txtJmlhPembayaran);
        lytTransferBank = (LinearLayout) findViewById(R.id.lytTransferBank);
        lytKartuKredit = (LinearLayout) findViewById(R.id.lytKartuKredit);
        rgPembayaran = (RadioGroup) findViewById(R.id.rgPembayaran);
        Tiket tiket = new Tiket();
        List<Konser> listKonser = Konser.listKonser;
        for(Konser konser: listKonser) {
            View child = getLayoutInflater().inflate(R.layout.item_konser, null);
            lytCBKonser.addView(child);
            CheckBox cbKonser = (CheckBox) child.findViewById(R.id.cbKonserItem);
            cbKonser.setText(konser.getNamaKonser());
            TextView txtHargaKonserItem = (TextView) child.findViewById(R.id.txtHargaKonserItem);
            txtHargaKonserItem.setText("Harga Tiket : " + formater.format(konser.getHargaKonser()));
            MaterialCardView cardKonser = (MaterialCardView) child.findViewById(R.id.cardKonser);
            cardKonser.setVisibility(View.GONE);
            cbKonser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        cardKonser.setVisibility(View.VISIBLE);
                        tiket.addKonser(konser, 0);
                        txtJmlhPembayaran.setText(formater.format(tiket.calcHarga()));
                        TextInputEditText txtQtyKonserItem = child.findViewById(R.id.txtQtyKonserItem);
                        txtQtyKonserItem.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                if (!txtQtyKonserItem.getText().toString().equals("")) {
                                    tiket.setQtyKonser(konser, Integer.parseInt(txtQtyKonserItem.getText().toString()));
                                    txtJmlhPembayaran.setText(formater.format(tiket.calcHarga()));
                                }
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                            }
                        });
                    } else {
                        tiket.removeKonser(konser);
                        cardKonser.setVisibility(View.GONE);
                    }
                }
            });
        }
        rgPembayaran.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = (RadioButton) findViewById(i);
                if (rb.getText().toString().equals(getResources().getString(R.string.transfer_bank))) {
                    lytTransferBank.setVisibility(View.VISIBLE);
                    lytKartuKredit.setVisibility(View.GONE);
                } else if (rb.getText().toString().equals(getResources().getString(R.string.kartu_kredit))) {
                    lytTransferBank.setVisibility(View.GONE);
                    lytKartuKredit.setVisibility(View.VISIBLE);
                } else {
                    lytTransferBank.setVisibility(View.GONE);
                    lytKartuKredit.setVisibility(View.GONE);
                }

            }
        });
    }
}