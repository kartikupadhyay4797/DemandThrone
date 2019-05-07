package com.example.demandthrone;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    ArrayList<Heir> list;
    Intent intent;

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            list=new ArrayList<>();
            intent=new Intent(this,Login.class);
            intent.putExtra("list",list);

            setContentView(R.layout.activity_main);
            //display the logo during 5 seconds,
            new CountDownTimer(5000,1000){
                @Override
                public void onTick(long millisUntilFinished){}

                @Override
                public void onFinish(){
                    //set the new Content of your activity
                    startActivity(intent);
                }
            }.start();
        }
}
