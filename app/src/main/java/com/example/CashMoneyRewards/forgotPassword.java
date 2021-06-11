package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {

    EditText emailForgotPasswordEdt;
    Button continueBtnForgotPwd, signInBtnForgotPwd;
    FirebaseAuth fireAuth;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_forgot_password );

        emailForgotPasswordEdt = findViewById( R.id.emailForgotPasswordEdt );

        continueBtnForgotPwd = findViewById( R.id.continueBtnForgotPwd );
        signInBtnForgotPwd = findViewById( R.id.signInBtnForgotPwd );

        fireAuth = FirebaseAuth.getInstance();
        back = findViewById( R.id.back );

        //SignIn Button Activate
        signInBtnForgotPwd.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent( forgotPassword.this, Login.class );
                startActivity( i );

            }
        } );

        //Forgot password Validation  [continueBtnForgotPwd]---------------------------------------------------------------------------------------------------
        //Continue Button Activate
        continueBtnForgotPwd.setOnClickListener( new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (!validEmail()) {
                    return;
                }

                String email = emailForgotPasswordEdt.getText().toString();

                fireAuth.sendPasswordResetEmail( email ).addOnCompleteListener( new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText( forgotPassword.this, "Password reset, Successfully! Check your email...", Toast.LENGTH_SHORT ).show();
                            finish();

                            Intent i = new Intent( forgotPassword.this,Login. class);
                            startActivity( i );
                        } else {
                            Toast.makeText( forgotPassword.this, "Something went wrong, Please try again!", Toast.LENGTH_SHORT ).show();
                        }
                    }
                } );
            }
        } );
        //---------------------------------------------------------------------------------------------------------------------------------------

    }

    //Form Validations------------------------------------------------------------------------------------------------------------------------
    private boolean validEmail() {
        String val = emailForgotPasswordEdt.getText().toString();

        if (val.isEmpty()) {
            emailForgotPasswordEdt.setError( "This field cannot be Empty" );
            return false;
        } else {
            emailForgotPasswordEdt.setError( null );
            return true;
        }
    }

    public void back(View view) {
        Intent intent = new Intent( forgotPassword.this, Login.class );
        startActivity( intent );
    }
    //---------------------------------------------------------------------------------------------------------------------------------
}
