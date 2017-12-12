package com.example.consumer.termproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by Alexis Cruz on 05/14/2016.
 */
public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //setting up the OnClick Property
    // Using v.getID because of the lgin button and sign up botton
    public void Login(View v){
        if(v.getId()== R.id.loginButton){
            EditText userinput = (EditText)findViewById(R.id.userET);
            String uInput = userinput.getText().toString();
            EditText userPass = (EditText)findViewById(R.id.passET);
            String uPass = userPass.getText().toString();
            String password = helper.searchPass(uPass);

            if(uPass.equals(password)){
                Intent i = new Intent(MainActivity.this,Display.class);
                i.putExtra("username",uInput);
                startActivity(i);
            }
            else{
                Toast loginfail= Toast.makeText(this,"UserName and/or password do not match",Toast.LENGTH_SHORT);
                loginfail.show();
            }
        }
        if(v.getId() == R.id.signUpPage){
            Intent i = new Intent(MainActivity.this,SignUp.class);
            startActivity(i);
        }
    }
}
