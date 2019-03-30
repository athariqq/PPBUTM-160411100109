package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton, rabutt1, rabutt2;
    TextView textView, hasilView, textView2, kembalian;
    Integer jumlahPesan, x, y, z, total;
    EditText inputBiaya, jumlahPes;
    CheckBox ayamgep, miegep, telgep;

    private Button btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radioGroup = findViewById(R.id.radioGroup);

        textView2 = findViewById(R.id.textView2);
        hasilView = findViewById(R.id.result_int);
        rabutt1 = findViewById(R.id.rabutt1);
        rabutt2 = findViewById(R.id.rabutt2);
        ayamgep = findViewById(R.id.cbayamgep);
        miegep = findViewById(R.id.cbmiegep);
        telgep = findViewById(R.id.cbtelgep);
        inputBiaya = findViewById(R.id.inputBiaya);
        kembalian = findViewById(R.id.kembalian);
        jumlahPes = findViewById(R.id.jumlahPes);
        btn_call = findViewById(R.id.btn_call);
//        Button button_order_radio = findViewById(R.id.button_order_radio);
//        button_order_radio.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int radioId = radioGroup.getCheckedRadioButtonId();
//
//                radioButton = findViewById(radioId);
//                textView.setText("Your Pilihan " + radioButton.getText());
//
//
//            }
//        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDial();
                Toast.makeText(getApplicationContext(),"Helleh ...",Toast.LENGTH_SHORT).show();
            }
        });

//        Button btn_call = findViewById(R.id.btn_call);
//        btn_call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                openDial();
//                Toast.makeText(getApplicationContext(),"Helleh ...",Toast.LENGTH_SHORT).show();
//            }
//        });
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
                Toast.makeText(getApplicationContext(), "Helleh Menu 1...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(), "Helleh Menu 2...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, " Selected Radio Button " + radioButton.getText(), Toast.LENGTH_SHORT).show();

    }

    public void order(View view) {
        Integer mincola = 3000, minfanta = 5000,
                makayamgep = 10000, makmiegep = 12000, maktelgep = 8000,
                jumlahPesan;


        int radioId = radioGroup.getCheckedRadioButtonId();
        jumlahPesan = Integer.valueOf(jumlahPes.getText().toString());

        if (jumlahPesan > 0) {
            String hasil;

            if (radioId == rabutt1.getId() && (ayamgep.isChecked() || miegep.isChecked() || telgep.isChecked())) {
                if (ayamgep.isChecked()) {
                    x = (makayamgep + mincola) * jumlahPesan;
                    y = 0;
                    z = 0;

                    if (miegep.isChecked()) {
                        y = (makmiegep + mincola) * jumlahPesan;
                        z = 0;
                    } else if (miegep.isChecked() && telgep.isChecked()) {
                        y = (makmiegep + mincola) * jumlahPesan;
                        z = maktelgep * jumlahPesan;
                    } else if (telgep.isChecked()) {
                        y = 0;
                        z = (maktelgep + mincola) * jumlahPesan;
                    }
                    total = x + y + z;

                } else if (miegep.isChecked()) {
                    x = 0;
                    y = (makmiegep + mincola) * jumlahPesan;
                    z = 0;
                    if (ayamgep.isChecked()) {
                        x = (makayamgep + mincola) * jumlahPesan;
                        z = 0;
                    } else if (ayamgep.isChecked() && telgep.isChecked()) {
                        x = (makayamgep + mincola) * jumlahPesan;
                        z = (maktelgep + mincola) * jumlahPesan;
                    } else if (telgep.isChecked()) {
                        x = 0;
                        z = (maktelgep + mincola) * jumlahPesan;
                    }
                    total = x + y + z;
                } else if (telgep.isChecked()) {
                    x = 0;
                    y = 0;
                    z = (maktelgep + mincola) * jumlahPesan;
                    if (ayamgep.isChecked()) {
                        x = (makayamgep + mincola) * jumlahPesan;
                        y = 0;
                    } else if (ayamgep.isChecked() && miegep.isChecked()) {
                        x = (makayamgep + mincola) * jumlahPesan;
                        y = (makmiegep + mincola) * jumlahPesan;
                    } else if (miegep.isChecked()) {
                        x = 0;
                        y = (makmiegep + mincola) * jumlahPesan;
                    }
                    total = x + y + z;
                }

                hasil = total.toString();
                textView2.setText(hasil);


            }

            if (radioId == rabutt2.getId() && (ayamgep.isChecked() || miegep.isChecked() || telgep.isChecked())) {
                if (ayamgep.isChecked()) {
                    x = (makayamgep + minfanta) * jumlahPesan;
                    y = 0;
                    z = 0;

                    if (miegep.isChecked()) {
                        y = (makmiegep + minfanta) * jumlahPesan;
                        z = 0;
                    } else if (miegep.isChecked() && telgep.isChecked()) {
                        y = (makmiegep + minfanta) * jumlahPesan;
                        z = (makmiegep + minfanta) * jumlahPesan;
                    } else if (telgep.isChecked()) {
                        y = 0;
                        z = (maktelgep + minfanta) * jumlahPesan;
                    }
                    total = x + y + z;

                } else if (miegep.isChecked()) {
                    x = 0;
                    y = (makmiegep + minfanta) * jumlahPesan;
                    z = 0;
                    if (ayamgep.isChecked()) {
                        x = (makayamgep + minfanta) * jumlahPesan;
                        z = 0;
                    } else if (ayamgep.isChecked() && telgep.isChecked()) {
                        x = (makayamgep + minfanta) * jumlahPesan;
                        z = (maktelgep + minfanta) * jumlahPesan;
                    } else if (telgep.isChecked()) {
                        x = 0;
                        z = (maktelgep + minfanta) * jumlahPesan;
                    }
                    total = x + y + z;
                } else if (telgep.isChecked()) {
                    x = 0;
                    y = 0;
                    z = (maktelgep + minfanta) * jumlahPesan;
                    if (ayamgep.isChecked()) {
                        x = (makayamgep + minfanta) * jumlahPesan;
                        y = 0;
                    } else if (ayamgep.isChecked() && miegep.isChecked()) {
                        x = (makayamgep + minfanta) * jumlahPesan;
                        y = (makmiegep + minfanta) * jumlahPesan;
                    } else if (miegep.isChecked()) {
                        x = 0;
                        y = (makmiegep + minfanta) * jumlahPesan;
                    }
                    total = x + y + z;
                }

                hasil = total.toString();
                textView2.setText(hasil);


            }
        }
    }

    public void pembayaran(View view) {
        Integer jumlahTotal, uangmu, kembalianmu;
        jumlahTotal = Integer.valueOf(textView2.getText().toString());
        uangmu = Integer.valueOf(inputBiaya.getText().toString());
        if (uangmu > jumlahTotal) {
            kembalianmu = uangmu - jumlahTotal;
            kembalian.setText(kembalianmu.toString());
        }
    }

    public void openDial() {
        Intent intentDial = new Intent(Intent.ACTION_DIAL);
        intentDial.setData(Uri.parse("tel:085333140017"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intentDial);
    }
}