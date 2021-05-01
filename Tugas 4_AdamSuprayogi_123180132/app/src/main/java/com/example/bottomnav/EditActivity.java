package com.example.bottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    Button kembali,simpan;
    EditText nama,password;
    SharedPreferences profilPreferences;
    String nameStr,emailStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit);

        profilPreferences = getSharedPreferences("MyProfile", MODE_PRIVATE);
        Boolean check = profilPreferences.getBoolean("LOGGED",false);
        if (check){
            profilPreferences = getApplicationContext().getSharedPreferences( "MyProfile", MODE_PRIVATE);
            String name1 = profilPreferences.getString("Name", "");
            String email1 = profilPreferences.getString("Email", "");
            EditText name,email;
            name = findViewById(R.id.et_nam);
            email = findViewById(R.id.et_email);
            email.setText(email1);
            name.setText(name1);
        }


        kembali = findViewById(R.id.btn_kembali);
        simpan = findViewById(R.id.btn_simpan);


        nama = findViewById(R.id.et_nam);
        password = findViewById(R.id.et_email);


        profilPreferences = getSharedPreferences("MyProfile", MODE_PRIVATE);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama = nama.getText().toString();
                String getEmail = password.getText().toString();

                SharedPreferences.Editor editor = profilPreferences.edit();
                editor.putString("Name", getNama);
                editor.putString("Email", getEmail);
                editor.putBoolean("LOGGED", true);
                editor.apply();


                Toast.makeText(getApplicationContext(),"Tombol simpan berhasil ditekan",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditActivity.this, FrameworkActivity.class);
                EditActivity.this.startActivity(intent);
                finish();
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, FrameworkActivity.class);
                EditActivity.this.startActivity(intent);
                finish();
            }
        });
    }
}