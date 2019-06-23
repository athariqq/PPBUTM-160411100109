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
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTugas1 extends AppCompatActivity {
    TextView tampilText,tampilText1,tampilText2,tampilText3,tampilText4,txt1,txt2;
    EditText inputText,inputText2,inputText3;
    Button button1,button2;
    String word,word1,word2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas1);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Nomer 1
        tampilText = findViewById(R.id.tampilText);
        txt1 = findViewById(R.id.txt1);
        inputText = findViewById(R.id.inputText);
        button1 = findViewById(R.id.button1);

        //Nomer 2
        tampilText2 = findViewById(R.id.tampilText2);
        txt2 = findViewById(R.id.txt2);
        inputText2 = findViewById(R.id.inputTextTB);
        inputText3 = findViewById(R.id.inputTextBB);
        button2 = findViewById(R.id.button2);
    }

    public void showToast(View view) {
        tampilText = (TextView) findViewById(R.id.inputText);
        word = tampilText.getText().toString();

        tampilText1 = (TextView) findViewById(R.id.txt1);
        tampilText1.setText(word);
    }

    public void showToast2(View view){
        //tb
        word1 = inputText2.getText().toString();
        //bb
        word2 = inputText3.getText().toString();

        Float var1 = Float.valueOf(word1);
        Float var3 = var1 * var1;

        Float bmi = Float.valueOf(word2)/var3;

        tampilText4 = (TextView) findViewById(R.id.txt2);
        tampilText4.setText(String.valueOf(bmi));

        if (bmi < 18.4){
            tampilText4.setText(String.valueOf(bmi)+" Underweight");
        }
        else if (bmi >= 18.5 && bmi <= 24.9){
            tampilText4.setText(String.valueOf(bmi)+" Normalweight");
        }
        else if (bmi >= 25 && bmi <= 29.9){
            tampilText4.setText(String.valueOf(bmi)+" Overweight");
        }
        else if (bmi >= 30 && bmi <= 34.9){
            tampilText4.setText(String.valueOf(bmi)+" Obesity 1");
        }
        else if (bmi >= 35 && bmi <= 39.9){
            tampilText4.setText(String.valueOf(bmi)+" Obesity 2");
        }
        else {
            tampilText4.setText(String.valueOf(bmi)+" Obesity 3");
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
