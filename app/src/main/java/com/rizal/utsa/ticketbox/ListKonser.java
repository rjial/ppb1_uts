package com.rizal.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rizal.utsa.ticketbox.model.Konser;

import java.util.ArrayList;
import java.util.List;

public class ListKonser extends AppCompatActivity {

    private List<String> listKonser = new ArrayList<>();
    private ListView lvKonser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_konser);
        for(Konser konser: Konser.listKonser) {
            listKonser.add(konser.getNamaKonser());
        }
        String[] arrKonser = listKonser.toArray(new String[0]);
        lvKonser = (ListView) findViewById(R.id.lvKonser);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListKonser.this, android.R.layout.simple_list_item_1, android.R.id.text1, arrKonser);
        lvKonser.setAdapter(adapter);
        lvKonser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListKonser.this, ItemKonser.class);
                intent.putExtra("KONSER", Konser.listKonser.get(i));
                startActivity(intent);
            }
        });
    }
}