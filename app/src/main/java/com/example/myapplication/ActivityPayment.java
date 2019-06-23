package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityPayment extends AppCompatActivity {
    TextView detailtxt, ket, masukanUangtxt, hargatotal, namatxt, kembalian, kembaliantxt,susukmu;
    EditText jumlahUangmu;
    Button btnbayar;
    String rdbhs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        hargatotal = findViewById(R.id.hargatotal);
        namatxt = findViewById(R.id.namatxt);
        jumlahUangmu = findViewById(R.id.jumlahUangmu);
        kembaliantxt = findViewById(R.id.kembaliantxt);
        kembalian = findViewById(R.id.kembalian);
        detailtxt = findViewById(R.id.detailtxt);
        ket = findViewById(R.id.ket);
        masukanUangtxt = findViewById(R.id.masukanUangtxt);
        btnbayar = findViewById(R.id.btnbayar);
        susukmu = findViewById(R.id.susukmu);

        Integer jumlahPesanan;
        Intent tot = getIntent();

        jumlahPesanan = tot.getIntExtra("JumlahAll",0);

        hargatotal.setText(jumlahPesanan.toString());
    }

    public void bayar(View view) {
        Integer totalHarga, uangmu, kembalianmu;
        totalHarga = Integer.valueOf(hargatotal.getText().toString());
        uangmu = Integer.valueOf(jumlahUangmu.getText().toString());

        if (uangmu > totalHarga) {
            kembalianmu = uangmu - totalHarga;
            susukmu.setText("Kembalianmu = "+ kembalianmu.toString());
        }

        if (uangmu < totalHarga) {
            Toast.makeText(getApplicationContext(),"kurang anjir" ,Toast.LENGTH_SHORT).show();
        }
    }
}

