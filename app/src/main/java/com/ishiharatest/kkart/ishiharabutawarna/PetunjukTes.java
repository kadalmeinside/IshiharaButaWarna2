package com.ishiharatest.kkart.ishiharabutawarna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by gilangparase on 25/02/2016.
 */

public class PetunjukTes extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_tes);
    }

    public void clickMulai(View view) {
        Intent objIntent = new Intent(PetunjukTes.this, TestActivity.class);
        startActivity(objIntent);
        finish();
    }

}
