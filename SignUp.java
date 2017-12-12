package com.example.consumer.termproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by Alexis Cruz on 05/14/2016.
 */
public class SignUp extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signUpClick(View v){
        if(v.getId()== R.id.signInButton){
            EditText name = (EditText)findViewById(R.id.nameSignET);
            EditText address = (EditText)findViewById(R.id.addressET);
            EditText Email = (EditText)findViewById(R.id.emailET);
            EditText passw = (EditText)findViewById(R.id.passSignET);
            EditText cpassw = (EditText)findViewById(R.id.confirmET);


            String nammestr = name.getText().toString();
            String addstr = address.getText().toString();
            String emailstr =Email.getText().toString();
            String passstr = passw.getText().toString();
            String cpassstr = cpassw.getText().toString();

            // if statement to check if passwords dont match
            if(!passstr.equals(cpassstr)){
                Toast pass = Toast.makeText(this,"Passwords do not match",Toast.LENGTH_LONG);
                pass.show();
            }
            //else statement if they do match, the information will be passed on
            else{
                UserInfo u = new UserInfo();
                u.setName(nammestr);
                u.setAdd(addstr);
                u.setEmail(emailstr);
                u.setPass(passstr);

                helper.insertUserInfo(u);
            }
        }
    }
}
