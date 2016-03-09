package com.ishiharatest.kkart.ishiharabutawarna;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * Created by gilangparase on 25/02/2016.
 */
public class SampleAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private String[] menu;
    private String[] submenu;

    public SampleAdapter(Context c) {
        inflater = LayoutInflater.from(c);
    }

    public void setData(String[] menu2, String[] submenu2) {
        this.menu = menu2;
        this.submenu = submenu2;
    }

    @Override
    public int getCount() {
        return menu.length;
    }

    @Override
    public Object getItem(int position) {
        return menu[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null) {
            /** gunakan xml untuk list itemnya */
            convertView = inflater.inflate(R.layout.view_about, null);

            holder = new ViewHolder();

            holder.title = (TextView) convertView.findViewById(R.id.menu_label);
            holder.subtitle = (TextView) convertView.findViewById(R.id.menu_labe2);

            /** untuk menampilkan data dari adapter
             * contoh textview label1 di isi dari array menu */
            holder.title.setText(menu[position]);
            holder.subtitle.setText(submenu[position]);

            convertView.setTag(holder);
        }
        else { holder = (ViewHolder) convertView.getTag(); }

        return convertView;
    }

    /** deklarasikan widget di sini */
    static class ViewHolder {
        TextView title;
        TextView subtitle;
    }
}

