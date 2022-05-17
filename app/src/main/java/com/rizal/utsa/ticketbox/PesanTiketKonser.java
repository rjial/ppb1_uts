package com.rizal.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.text.DecimalFormatSymbols;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class PesanTiketKonser extends AppCompatActivity {

    private LinearLayout lytCBKonser, lytKotaKonser, lytTransferBank, lytKartuKredit;
    private TextView txtJmlhPembayaran;
    private RadioGroup rgPembayaran, rgPilihanIDDiri;
    private AutoCompleteTextView cbxKotaKonser;
    private TextInputEditText etxtTglBeli;
    private Locale myIndonesianLocale = new Locale("in", "ID");
    private NumberFormat formater = NumberFormat.getCurrencyInstance(myIndonesianLocale);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_tiket_konser);
        lytCBKonser = (LinearLayout) findViewById(R.id.lytCBKonser);
        txtJmlhPembayaran = (TextView) findViewById(R.id.txtJmlhPembayaran);
        lytTransferBank = (LinearLayout) findViewById(R.id.lytTransferBank);
        lytKartuKredit = (LinearLayout) findViewById(R.id.lytKartuKredit);
        rgPembayaran = (RadioGroup) findViewById(R.id.rgPembayaran);
        cbxKotaKonser = (AutoCompleteTextView) findViewById(R.id.cbxKotaKonser);
        ArrayAdapter<String> arrayKota = new ArrayAdapter<String>(this, R.layout.list_item, Tiket.listKotaKonser);
        cbxKotaKonser.setAdapter(arrayKota);
        Tiket tiket = new Tiket();
        List<Konser> listKonser = Konser.listKonser;
        txtJmlhPembayaran.setText(formater.format(tiket.calcHarga()));
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
                        txtQtyKonserItem.setText("0");
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
                    tiket.setPembayaranPembeli(Tiket.Pembayaran.TRANSFER_BANK);
                } else if (rb.getText().toString().equals(getResources().getString(R.string.kartu_kredit))) {
                    lytTransferBank.setVisibility(View.GONE);
                    lytKartuKredit.setVisibility(View.VISIBLE);
                    tiket.setPembayaranPembeli(Tiket.Pembayaran.KARTU_KREDIT);
                } else {
                    lytTransferBank.setVisibility(View.GONE);
                    lytKartuKredit.setVisibility(View.GONE);
                }

            }
        });
        final LocalDateTime[] dateTime = {LocalDateTime.now()};
        etxtTglBeli = (TextInputEditText) findViewById(R.id.etxtTglBeli);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                dateTime[0] = LocalDateTime.of(i, i1, i2, 0,0,0);
                etxtTglBeli.setText(formatter.format(dateTime[0]));
                Log.d("DATE", formatter.format(dateTime[0]));
            }
        };
        etxtTglBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PesanTiketKonser.this, date, dateTime[0].getYear(), dateTime[0].getMonthValue(), dateTime[0].getDayOfMonth()).show();
            }
        });
        cbxKotaKonser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tiket.setKota(Tiket.listKotaKonser.get(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        rgPilihanIDDiri = (RadioGroup) findViewById(R.id.rgPilihanIDDiri);
        rgPilihanIDDiri.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View view = radioGroup.getRootView();
                RadioButton rb = view.findViewById(i);
                tiket.setJenisID(rb.getText().toString());
            }
        });

    }
}