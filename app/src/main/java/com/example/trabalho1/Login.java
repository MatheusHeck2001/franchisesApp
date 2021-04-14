package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setEnabled(false);

        findViewById(R.id.username).setOnKeyListener(
                new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        Log.i("key:", String.valueOf(keyCode));
                        final EditText username = (EditText) findViewById(R.id.username);
                        final EditText password = (EditText) findViewById(R.id.password);
                        loginButton.setEnabled(!username.getText().toString().equals("") ||
                                !password.getText().toString().equals(""));
                        return true;
                    }
                }
        );
        loginButton.setEnabled(false);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);

                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Intent it = new Intent(Login.this, MainActivity.class);
                    startActivity(it);
                } else {
                    TextView wrongCred = (TextView) findViewById(R.id.wrongCred);
                    wrongCred.setTextColor(Color.rgb(255,0,0));
                    wrongCred.setText("Wrong credencials...");
                }

            }

        });


    }

}