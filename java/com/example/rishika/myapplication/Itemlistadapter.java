package com.example.rishika.myapplication;

/**
 * Created by pragati on 12/12/2016.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Itemlistadapter extends BaseAdapter {
    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    private Context mcontext;
    private List<Item> mProductlist;
    ArrayList<Item> arraylist;
    //constructor


    public Itemlistadapter(Context mcontext, List<Item> mProductlist) {
        this.mcontext = mcontext;
        this.mProductlist = mProductlist;
        arraylist=new ArrayList<Item>();
        arraylist.addAll(mProductlist);
    }

    @Override
    public int getCount() {
        return mProductlist.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return mProductlist.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(mcontext,R.layout.listviewdatalayout,null);
        Item data=mProductlist.get(position);

       // TextView id=(TextView)v.findViewById(R.id.textViewID);
      //  TextView id=(TextView)v.findViewById(R.id.textViewID);
        ImageView imageView=(ImageView)v.findViewById(R.id.imgplant);
        TextView tvbotanicalname=(TextView)v.findViewById(R.id.textViewNAME);
        TextView tvenglishname=(TextView)v.findViewById(R.id.textViewENGLISH);
        TextView tvnepaliname=(TextView)v.findViewById(R.id.textViewNEPALI);
        TextView tvlocation=(TextView)v.findViewById(R.id.textViewLOCATION);
        TextView tvdescription=(TextView)v.findViewById(R.id.textViewDESCRIPTION);



        //  id.setText(data.getId());
        byte[] plantimage = data.getImage();

        tvbotanicalname.setText(data.getBotanicalname());
        tvenglishname.setText(data.getEnglishname());
        tvnepaliname.setText(data.getNepaliname());
        tvlocation.setText(data.getLocation());
        tvdescription.setText(data.getDescription());
        //id.setText(data.getId());
        v.setTag(data.getBotanicalname());
        Bitmap bitmap = BitmapFactory.decodeByteArray(plantimage, 0, plantimage.length);
        imageView.setImageBitmap(bitmap);



        return v;
    }



    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());

        mProductlist.clear();
        if (charText.length() == 0) {
            mProductlist.addAll(arraylist);

        } else {
            for (Item postDetail : arraylist) {
                if (charText.length() != 0
                        && (postDetail.getBotanicalname().toLowerCase(Locale.getDefault()).contains(charText)
                        || postDetail.getEnglishname().toLowerCase(Locale.getDefault()).contains(charText)
                        || postDetail.getNepaliname().toLowerCase(Locale.getDefault()).contains(charText)
                )) {
                    mProductlist.add(postDetail);
                }
            }
        }
        notifyDataSetChanged();
    }
}



