package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends AppCompatActivity {

    EditText email, name, pass, address;
    Button btsignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        address = (EditText) findViewById(R.id.address);
        btsignin = (Button) findViewById(R.id.btsignin);

        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences s = getSharedPreferences("D04", MODE_PRIVATE);
                SharedPreferences.Editor ed = s.edit();
                String ten = name.getText().toString();
                String matkhau = pass.getText().toString();
                String diachi = address.getText().toString();
                String mail = email.getText().toString();
                ed.putString("t", ten);
                ed.putString("mk", matkhau);
                ed.putString("dc", diachi);
                ed.putString("mail", mail);
                ed.commit();
                    Toast.makeText(signin.this, "successfull", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(signin.this, login_sreen.class);
                    startActivity(i);
            }
        });
    }
}