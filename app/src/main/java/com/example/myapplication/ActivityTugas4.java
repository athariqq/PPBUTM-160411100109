package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityTugas4 extends AppCompatActivity {

    public RecyclerView recyclerView;
    public OrderAdapter adapter;
    public RecyclerView.LayoutManager layoutManager;
    public ArrayList<Makanan> foodArrayList;

    TextView namapemesan,jumlahtxt;
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas4);


        order = findViewById(R.id.order);
        recyclerView = findViewById(R.id.recycler_view);
        jumlahtxt = findViewById(R.id.jumlahtxt);

        addData();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new OrderAdapter(this, foodArrayList);

        layoutManager = new LinearLayoutManager(ActivityTugas4.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    void addData(){
        foodArrayList = new ArrayList<>();
        foodArrayList.add(new Makanan("Ayam Geprek", "15000", "0", 0,0));
        foodArrayList.add(new Makanan("Mie Geprek", "20000", "0", 0,1));
        foodArrayList.add(new Makanan("Telur Geprek", "10000", "0", 0,2));
        foodArrayList.add(new Makanan("Aham Siswana", "1214378098", "0",0,3));
    }

    public void order(View view) {
        Integer ayamgep = foodArrayList.get(0).getTotal();
        Integer miegep = foodArrayList.get(1).getTotal();
        Integer telurgep = foodArrayList.get(2).getTotal();

        Integer hasil = ayamgep+miegep+telurgep;
        Intent openActPayment = new Intent(this,ActivityPayment.class);

            if (ayamgep!=0 || miegep!=0 || telurgep!=0){
                openActPayment.putExtra("JumlahAll",hasil);
                startActivity(openActPayment);
            }
            else {
                Toast.makeText(this,"Menu e kosong njir",Toast.LENGTH_SHORT).show();
            }
        }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_awal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                openActivityHome();
                return true;
            case R.id.menu1:
                openActivityAbout();
                return true;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(), "Helleh Menu 2...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Integer index = data.getIntExtra("index",0);
                Integer jumlahmenu = data.getIntExtra("jumlahmenubaru",0);
                Integer total = data.getIntExtra("totalHarga",0);

                foodArrayList.get(index).setJumlah(jumlahmenu.toString());
                foodArrayList.get(index).setTotal(total);
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void openActivityAbout(){
        Intent intent_about = new Intent(this, ActivityAbout.class);
        startActivity(intent_about);
    }

    public void openActivityHome() {
        Intent homeIntent = new Intent(this, MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}