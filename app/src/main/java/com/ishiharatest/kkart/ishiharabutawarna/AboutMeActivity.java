package com.ishiharatest.kkart.ishiharabutawarna;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.ListView;

public class AboutMeActivity extends Activity {
    SampleAdapter mAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.listViewAbout);

        mAdapter = new SampleAdapter(this);

        /** data array untuk di tampilkan dalam listview */
        String[] menu = {"App Name", "App Version", "Author", "Check for update"};
        String[] submenu = {"Tes Buta Warna Ishihara", "1.0.0.1", "gilangparase", "Check for online update"};

        /** masukan array ke dalam adapter yang tadi dibuat, jangan salah posisi ya */
        mAdapter.setData(menu, submenu);

        /** gunakan custom adapter yang tadi di buat */
        mListView.setAdapter(mAdapter);
    }

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