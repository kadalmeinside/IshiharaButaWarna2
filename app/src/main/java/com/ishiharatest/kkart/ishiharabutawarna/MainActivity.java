package com.ishiharatest.kkart.ishiharabutawarna;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
/**
 * Created by gilangparase on 25/02/2016.
 */

public class MainActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView startTest = (ImageView) this.findViewById(R.id.btnStart);
        ImageView startAbout = (ImageView) this.findViewById(R.id.btnAbout);
        ImageView startInfo = (ImageView) this.findViewById(R.id.btnButaWarna);
        ImageView startExit = (ImageView) this.findViewById(R.id.btnKeluar);
        startTest.setOnClickListener((View.OnClickListener) this);
        startAbout.setOnClickListener((View.OnClickListener) this);
        startInfo.setOnClickListener((View.OnClickListener) this);
        startExit.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnStart) {
            Intent i = new Intent(getApplicationContext(), PetunjukTes.class);
            startActivity(i);
        }  else if(v.getId() == R.id.btnAbout) {
            Intent i = new Intent(getApplicationContext(), AboutMeActivity.class);
            startActivity(i);
        }  else if(v.getId() == R.id.btnButaWarna) {
            Intent i = new Intent(getApplicationContext(), InfoButaWarna.class);
            startActivity(i);
        } else if(v.getId() == R.id.btnKeluar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Apakah anda yakin ingin keluar dari aplikasi ?");
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //if user pressed "yes", then he is allowed to exit from application
                    finish();
                }
            });
            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //if user select "No", just cancel this dialog and continue with app
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
