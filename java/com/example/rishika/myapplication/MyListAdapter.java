package com.example.rishika.myapplication;

import android.app.Activity;
import android.content.ClipData;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Rishika on 1/19/2017.
 */

public class MyListAdapter extends ArrayAdapter<String>
{
    private final Activity context;
    private final String [] plants;
    private final Integer [] plantimages;
    private List<String> stringList;
    ArrayList<String> arraylist;


    public MyListAdapter(Activity context, String[] plants, Integer[] plantimages) {
        super(context, R.layout.layout_image_list,plants);
        this.context = context;
        this.plants = plants;
        this.plantimages = plantimages;
        ArrayList<String> stringList = new ArrayList(Arrays.asList(plants)); //new ArrayList is only needed if you absolutely need an ArrayList
        arraylist.addAll(stringList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.layout_image_list,null,true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView9);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView7);

        txtTitle.setText(plants[position]);
        imageView.setImageResource(plantimages[position]);
        return rowView;

    }

    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());

        stringList.clear();
        if (charText.length() == 0) {
            stringList.addAll(arraylist);

        } else {
            for (String postDetail : arraylist) {
                if (charText.length() != 0 && postDetail.toLowerCase(Locale.getDefault()).contains(charText)) {
                    stringList.add(postDetail);
                }
            }
        }
        notifyDataSetChanged();
    }
}
