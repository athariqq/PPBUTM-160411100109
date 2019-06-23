package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_tugas1;
    private Button button_tugas2;
    private Button button_tugas3;
    private Button button_tugas4;
    private Button button_tugas5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        getSupportActionBar().setHomeButtonEnabled(true);

        button_tugas1 = findViewById(R.id.button_tugas1);
        button_tugas2 = findViewById(R.id.button_tugas2);
        button_tugas3 = findViewById(R.id.button_tugas3);
        button_tugas4 = findViewById(R.id.button_tugas4);
        button_tugas5 = findViewById(R.id.button_tugas5);

        button_tugas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityTugas1();
            }
        });

        button_tugas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityTugas2();
            }
        });

        button_tugas3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLogin();
            }
        });

        button_tugas4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityTugas4();
            }
        });

        button_tugas5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityTugas5();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_awal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
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

    public void openActivityTugas1(){
        Intent intentTgs1 = new Intent(this, ActivityTugas1.class);
        startActivity(intentTgs1);
    }

    public void openActivityTugas2(){
        Intent intentTgs2 = new Intent(this, ActivityTugas2.class);
        startActivity(intentTgs2);
    }

    public void openActivityTugas4(){
        Intent intentTgs4 = new Intent(this, ActivityTugas4.class);
        startActivity(intentTgs4);
    }

    public void openActivityTugas5(){
        Intent intentTgs5 = new Intent(this, ActivityTugas5.class);
        startActivity(intentTgs5);
    }

    public void openActivityLogin(){
        Intent intenttgslogin = new Intent(this, ActivityLogin.class);
        startActivity(intenttgslogin);
    }

    public void openActivityAbout(){
        Intent intent_about = new Intent(this, ActivityAbout.class);
        startActivity(intent_about);
    }

}