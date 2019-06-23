package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    Button login_home;
    EditText usrname, passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_home = findViewById(R.id.login_home);
        usrname = findViewById(R.id.usrname);
        passw = findViewById(R.id.passw);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usrname.getText().toString().equals("haikal") && passw.getText().toString().equals("109")){
                    Toast.makeText(getApplicationContext(),"Redirecting ...",Toast.LENGTH_SHORT).show();
                    openActivityTugas2();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Something wrong with your brain ...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    public void login(View view) {
//    }

    public void openActivityTugas2(){
        Intent intenttgs2 = new Intent(this, ActivityTugas2.class);
        startActivity(intenttgs2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_awal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    public void openActivityAbout() {
        Intent intent_about = new Intent(this, ActivityAbout.class);
        startActivity(intent_about);
    }

    public void openActivityHome() {
        Intent homeIntent = new Intent(this, MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

}
