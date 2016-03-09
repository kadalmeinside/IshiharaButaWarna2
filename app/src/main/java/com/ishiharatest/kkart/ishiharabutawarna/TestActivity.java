package com.ishiharatest.kkart.ishiharabutawarna;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by gilangparase on 25/02/2016.
 */

public class TestActivity extends Activity {
    //Explicit
    private TextView questionTextView;
    private ImageView ishiharaImageView;
    private ImageView answerButton;
    private CheckBox checkBox;
    private EditText editTextJawaban;
    private int indexAnInt, scoreAnInt, intJawaban ;
    private int  scoreAnIntDeutan=0;
    private int  scoreAnIntProtan=0;
    private SSRUmodel objSsrUmodel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        //Bind Widget
        bindWidget();


        //Button Controller
        buttonController();



        //About Model
        aboutModel();

    }   //onCreate

    private void aboutModel() {

        objSsrUmodel = new SSRUmodel();
        objSsrUmodel.setOnSSRUmodelChangeListener(new SSRUmodel.OnSSRUmodelChangeListener() {
            @Override
            public void onSSRUmodelChangeListener(SSRUmodel ssrUmodel) {

                //Chang View
                changeView(ssrUmodel.getButtonAnInt());

            }   //event
        });

    }   //aboutModel

    private void changeView(int buttonAnInt) {

        //Change Image
        int intDrawabe[] = new int[]{R.drawable.plate01, R.drawable.plate02, R.drawable.plate03, R.drawable.plate04, R.drawable.plate05, R.drawable.plate06, R.drawable.plate07, R.drawable.plate08, R.drawable.plate09, R.drawable.plate10, R.drawable.plate11, R.drawable.plate12, R.drawable.plate13, R.drawable.plate14, R.drawable.plate15, R.drawable.plate16, R.drawable.plate17, R.drawable.plate18, R.drawable.plate19, R.drawable.plate20, R.drawable.plate21};
        ishiharaImageView.setImageResource(intDrawabe[buttonAnInt]);


    }   // changeView



    private void buttonController() {

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check Zero
                String stringJawaban = editTextJawaban.getText().toString();
                if (stringJawaban.matches("")) {
                    if (checkBox.isChecked()) {
                        intJawaban = 99;
                        checkZero();
                    } else {
                        intJawaban = 0;
                        checkZero();
                    }
                } else {
                    intJawaban = Integer.parseInt(stringJawaban);
                    checkZero();
                }

            }   // event
        });

    }   // buttonController


    private void checkZero() {
        if (intJawaban == 0) {

            Toast.makeText(TestActivity.this, "Anda Belum Memasukan Jawaban!", Toast.LENGTH_SHORT).show();

        } else {

            //Check Score
            checkScore();
            checkTimes();

        }

    }   //checkZero

    private void checkScore() {

        int intAnswer[] = new int[]{12, 3, 8, 15, 29, 57, 74, 5, 6, 2, 7, 16, 45, 73, 6, 97, 5, 26, 35, 42, 96};
        int intUser[] = new int[21];
        intUser[indexAnInt] = intJawaban;
        if (intUser[indexAnInt] == intAnswer[indexAnInt]) {
            scoreAnInt += 1;
        }
        else {
            if ((indexAnInt == 17) && (intUser[indexAnInt]==2)) {
                scoreAnIntDeutan=scoreAnIntDeutan+1;
            }
            if ((indexAnInt == 18) && (intUser[indexAnInt]==3)) {
                scoreAnIntDeutan+=1;
            }
            if ((indexAnInt == 19) && (intUser[indexAnInt]==4)) {
                scoreAnIntDeutan+=1;
            }
            if ((indexAnInt == 20) && (intUser[indexAnInt]==9)) {
                scoreAnIntDeutan += 1;
            }
            if ((indexAnInt == 17) && (intUser[indexAnInt]==6)) {
                scoreAnIntProtan +=1;
            }
            if ((indexAnInt == 18) && (intUser[indexAnInt]==5)) {
                scoreAnIntProtan +=1;
            }
            if ((indexAnInt == 19) && (intUser[indexAnInt]==2)) {
                scoreAnIntProtan +=1;
            }
            if ((indexAnInt == 20) && (intUser[indexAnInt]==6)) {
                scoreAnIntProtan +=1;
            }
        }

        editTextJawaban.setText("", TextView.BufferType.EDITABLE);
        checkBox.setChecked(false);

    }   //checkScore

    private void checkTimes() {

        if (indexAnInt == 20) {

            //Intent to ShowScore
            intentToShowScore();

        } else {

            //Increase
            indexAnInt += 1;

            //Show Controller Call View
            questionTextView.setText("Plate"+(Integer.toString(indexAnInt + 1)));

            //Show Controller Call Model
            objSsrUmodel.setButtonAnInt(indexAnInt);

        }   // if

    }   //checkTimes

    private void intentToShowScore() {

        String hasilScore = Integer.toString(scoreAnInt);
        String hasilScore2 = Integer.toString(scoreAnIntDeutan);
        String hasilScore3 = Integer.toString(scoreAnIntProtan);
        Intent objIntent = new Intent(this, ShowScoreActivity.class);
        Bundle extras = new Bundle();
        extras.putString("Score", hasilScore);
        extras.putString("Score2", hasilScore2);
        extras.putString("Score3", hasilScore3);
        objIntent.putExtras(extras);
        startActivity(objIntent);
        finish();
    }


    private void bindWidget() {

        questionTextView = (TextView) findViewById(R.id.textView2);
        ishiharaImageView = (ImageView) findViewById(R.id.imageView);
        editTextJawaban = (EditText) findViewById(R.id.editAnswer);
        answerButton = (ImageView) findViewById(R.id.btnAnswer);
        checkBox = (CheckBox) findViewById(R.id.checkBoxAnswer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Tes belum anda selesaikan" + "\n" + "Apakah anda yakin ingin keluar ?");
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

}   //Main Class
