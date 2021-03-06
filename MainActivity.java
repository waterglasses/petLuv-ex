package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import android.app.ProgressDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //define view objects
    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonSignup;
    TextView textviewSingin;
    TextView textviewMessage;
    //ProgressDialog progressDialog;
    //define firebase object
    FirebaseAuth firebaseAuth;

    //
    TextView Text_mypage;
    ImageButton Img_myPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializig firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class)); //추가해 줄 ProfileActivity
        }
        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textviewSingin= (TextView) findViewById(R.id.textViewSignin);
        textviewMessage = (TextView) findViewById(R.id.textviewMessage);
        buttonSignup = (Button) findViewById(R.id.buttonSignup);
        //progressDialog = new ProgressDialog(this);

        //
        Text_mypage = (TextView) findViewById(R.id.Text_mypage);
        Img_myPage = (ImageButton) findViewById(R.id.Img_myPage);

        //button click event
        buttonSignup.setOnClickListener(this);
        textviewSingin.setOnClickListener(this);
        //
        Text_mypage.setOnClickListener(this);
        Img_myPage.setOnClickListener(this);
    }

    //Firebse creating a new user
    private void registerUser(){
        //사용자가 입력하는 email, password를 가져온다.
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //email과 password가 비었는지 아닌지를 체크 한다.
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Email을 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password를 입력해 주세요.", Toast.LENGTH_SHORT).show();
        }


        //email과 password가 제대로 입력되어 있다면 계속 진행된다.
        //progressDialog.setMessage("등록중입니다. 기다려 주세요...");
        //progressDialog.show();


        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        } else {
                            //에러발생시
                 ��Z�6
  �['5u��4
  �@j�3H ��2)�M�1
  ��>0r4��/
  ����.Z�ܭ-Yn��,-�¸+']��*�Xl)Sr�(<��'
  �&y+A�% ��=$|N�#-��["
  ��H+!r�� P�e�p+��iɖ�p0ώ=%	:g�c�
  ��)�H��
  �h
  ք�\�OX��
  ��<;oXHf
  �\V�}�R6
  �Z)�0]]���zB"K�T
�i'	:x�
  ��j}
  �*��
  �]��
  ��qNI��
  ��!	:�7rN�      �^ �����v_I4������jT>&������r\F0�����~hR<&������pX@(
�
�
�
�
�
�
p
X
B
,
	�	�	�	�	�	�	v	^	F	/	������s]E/�����|fP8"������pYA+������pZB, �����w^                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 