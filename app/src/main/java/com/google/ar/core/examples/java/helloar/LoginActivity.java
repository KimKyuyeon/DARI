package com.google.ar.core.examples.java.helloar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText ID;
    EditText Pw;
    Button mLoginBtn;
    Button mRegistBtn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ID = findViewById(R.id.idText);
        Pw = findViewById(R.id.pwText);
        firebaseAuth =  FirebaseAuth.getInstance();

        mLoginBtn = findViewById(R.id.signInBtn);
        mRegistBtn = findViewById(R.id.singUpBtn);
        //가입 버튼이 눌리면
        mRegistBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //intent함수를 통해 register액티비티 함수를 호출한다.
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

    //로그인 버튼이 눌리면
        mLoginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = ID.getText().toString().trim();
                String pwd = Pw.getText().toString().trim();
                if (email.isEmpty() || pwd.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"The field is empty" ,Toast.LENGTH_SHORT).show();
                }
                else {
                    firebaseAuth.signInWithEmailAndPassword(email, pwd)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                    } else if (!task.isSuccessful()) {
                                        try {
                                            throw task.getException();
                                        } catch (FirebaseAuthInvalidUserException e) {
                                            Toast.makeText(LoginActivity.this, "ID doesn't exist", Toast.LENGTH_SHORT).show();
                                        } catch (FirebaseAuthInvalidCredentialsException e) {
                                            Toast.makeText(LoginActivity.this, "Not in email form", Toast.LENGTH_SHORT).show();
                                        } catch (FirebaseNetworkException e) {
                                            Toast.makeText(LoginActivity.this, "Firebase NetworkException", Toast.LENGTH_SHORT).show();
                                        } catch (Exception e) {
                                            Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                }
                            });
                }

            }
        });
    }

}