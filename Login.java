package com.example.demandthrone;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity {

    EditText heir;
    String heirString,houseString;
    ArrayList<Heir> list;
    Dialog dialog;

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Spinner staticSpinner = (Spinner) findViewById(R.id.house);

        // Create an ArrayAdapter using the string array and a custom spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.mystrings,
                        R.layout.spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);


        staticSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                houseString=(String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        Intent intent=getIntent();
        list = (ArrayList<Heir>) intent.getSerializableExtra("list");

    }

    public void openDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.alert_back);

        dialog.show();

    }

    public void follow(View view){
        String url = "https://www.linkedin.com/in/kartik-upadhyay-042570126";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void contribute(View view){
        String url = "https://github.com/kartikupadhyay4797/DemandThrone";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void talk(View view){

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:kartik4797@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "DEMAND THRONE USER");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "write here...");
        startActivity(Intent.createChooser(emailIntent, "SEND E-MAIL"));

    }

    public void gotIt(View view){
        dialog.dismiss();
    }

    public void submitted(View view) {
        heir=(EditText)findViewById(R.id.heir);
        heirString=heir.getText().toString();
        if (heirString.equals("") || houseString.equals("")){
            Toast toast=Toast.makeText(getApplicationContext(),"Always remember your name and your house!!!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            list.add(new Heir(heirString,houseString));
            Intent intent=new Intent(this,List.class);
            intent.putExtra("list",list);
            startActivityForResult(intent,9);

        }

    }

    public void helpMe(View view) {
        openDialog();
    }

    public void onBackPressed(){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

}
