package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_sreen extends AppCompatActivity {

    Button btlogin;
    EditText edmail, edpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sreen);
        btlogin = (Button) findViewById(R.id.btlogin);
        edmail = (EditText) findViewById(R.id.log_email);
        edpass = (EditText) findViewById(R.id.log_pass);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer a = Integer.valueOf(edmail.getText().toString());
                Integer b = Integer.valueOf(edpass.getText().toString());
                SharedPreferences s = getSharedPreferences("D041", MODE_PRIVATE);
                SharedPreferences.Editor ed = s.edit();
                ed.putInt("result", a + b);
                ed.apply();
                Toast.makeText(login_sreen.this, "Sum success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}