package com.ishiharatest.kkart.ishiharabutawarna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
/**
 * Created by gilangparase on 25/02/2016.
 */

public class ShowScoreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        //Show Score
        showScore();

    }   // onCreate

    public void clickExit(View view) {
        Intent objIntent = new Intent(ShowScoreActivity.this, MainActivity.class);
        startActivity(objIntent);
        finish();
    }

    public void clickPlay(View view) {
        Intent objIntent = new Intent(ShowScoreActivity.this, TestActivity.class);
        startActivity(objIntent);
        finish();
    }



    private void showScore() {

        //Receive Value From MainActivity
        Intent objIntent = getIntent();
        Bundle extras = objIntent.getExtras();
        String scoreSatu = extras.getString("Score");
        String scoreDua = extras.getString("Score2");
        String scoreTiga = extras.getString("Score3");

        int intScore = Integer.parseInt(scoreSatu);
        int intScore2 = Integer.parseInt(scoreDua);
        int intScore3 = Integer.parseInt(scoreTiga);
        int intSalah = 21 - intScore;

        //Show Value to TextView
        TextView showScoreTextView = (TextView) findViewById(R.id.txtShowScore);
        showScoreTextView.setText("Jawaban anda benar "+(Integer.toString(intScore)) + " dari 21 plate" );

        if (intSalah<=3){
            TextView showHasilTextView = (TextView) findViewById(R.id.txtShowKesimpulan);
            showHasilTextView.setText("Selamat "+ "\n" +
                    "Mata Anda Normal");
        }
        else if ((intSalah<=18)&&(intScore2==4)){
            TextView showHasilTextView = (TextView) findViewById(R.id.txtShowKesimpulan);
            showHasilTextView.setText("Deutan Kuat "+ "\n" +
                    "Buta warna deutan, apabila yang rusak atau lemah adalah bagian mata yang peka terhadap warna hijau.");

        }
        else if ((intSalah<=18)&&(intScore3==4)){
            TextView showHasilTextView = (TextView) findViewById(R.id.txtShowKesimpulan);
            showHasilTextView.setText("Protan Kuat"+"\n"+"Buta warna protan, apabila yang rusak atau lemah adalah bagian mata yang peka terhadap warna merah.");
        }
        else if (intSalah<=18){
            TextView showHasilTextView = (TextView) findViewById(R.id.txtShowKesimpulan);
            showHasilTextView.setText("Buta Warna Parsial"+"\n"+"Buta Warna Parsial adalah ketidak mampuan untuk membedakan warna-warna merah dan hijau");
        }
        else {
            TextView showHasilTextView = (TextView) findViewById(R.id.txtShowKesimpulan);
            showHasilTextView.setText("Buta Warna Total"+"\n"+" Buta warna tolal merupakan sebuah keadaan dimana seseorang tidak dapat mengenali warna sama sekali (semua warna dilihat sebagai tingkatan warna hitam, putih, dan abu-abu");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   // Main Class
