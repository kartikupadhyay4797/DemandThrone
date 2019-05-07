package com.example.demandthrone;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class List extends AppCompatActivity {
    MyAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Heir> list;
    Dialog dialog;

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        list = (ArrayList<Heir>) intent.getSerializableExtra("list");

        recyclerView = (RecyclerView) findViewById(R.id.reView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
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


    public void helpMe(View view) {
        openDialog();
    }
}