package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityCount2 extends AppCompatActivity {
    TextView namaMakanantxt,hargamenutxt, hasilcuks;
    EditText jumlahmenuMu;
    Button minusMenu,plusMenu,btnAddtoCart;
    Integer index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count2);
        namaMakanantxt = findViewById(R.id.namaMakanantxt);
        hargamenutxt = findViewById(R.id.hargamenutxt);
        jumlahmenuMu = findViewById(R.id.jumlahmenuMu);
        minusMenu = findViewById(R.id.minusMenu);
        plusMenu = findViewById(R.id.plusMenu);
        hasilcuks = findViewById(R.id.hasilcuks);
        btnAddtoCart = findViewById(R.id.btnAddtoCart);

        Intent intent = getIntent();
        index = intent.getIntExtra("index",0);
        String namamenu = intent.getStringExtra("txt_namaMkn");
        String hargamenu = intent.getStringExtra("txt_hargaMkn");

        namaMakanantxt.setText(namamenu);
        hargamenutxt.setText(hargamenu);
    }

    public void plus(View view){
        String j = jumlahmenuMu.getText().toString();
        if (j.isEmpty()){
            j="0";
            Integer jmlh = Integer.valueOf(j);
            Integer total = jmlh+1;
            jumlahmenuMu.setText(total.toString());
        }else {
            Integer jmlh = Integer.valueOf(j);
            Integer total = jmlh+1;
            jumlahmenuMu.setText(total.toString());
        }
    }
    public void minus(View view){
        String j = jumlahmenuMu.getText().toString();
        if (j.isEmpty()) {
            j = "0";
        }
        else {
            Integer jmlh = Integer.valueOf(j);
            if (jmlh > 0) {
                Integer total = jmlh - 1;
                jumlahmenuMu.setText(total.toString());
            }
        }
    }

    public void toChart(View view) {
        Integer harga,jumlah,total;

        harga=Integer.valueOf(hargamenutxt.getText().toString());
        jumlah=Integer.valueOf(jumlahmenuMu.getText().toString());
        total = harga * jumlah;

        Intent chart = new Intent(this,ActivityTugas4.class);
        chart.putExtra("jumlahmenubaru",jumlah);
        chart.putExtra("index",index);
        chart.putExtra("totalHarga",total);

        onActivityResult(1,RESULT_OK,chart);
        setResult(RESULT_OK,chart);
        finish();

    }
}
