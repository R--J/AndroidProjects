/**
 * Created by jon on 15/10/30.
 */
package com.helloworld.jon.mythirdapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    private final Context context;

    public FruitAdapter(Context context, int resourceId, List<Fruit> objects) {
        super(context, resourceId, objects);
        this.fruitList = objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Fruit getItem(int position) {
        return fruitList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        Fruit fruit = getItem(position);
        if (fruit != null) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_item, null);
            }
            ImageView fruitImage = (ImageView)(convertView.findViewById(R.id.imageView));
            TextView fruitName = (TextView)(convertView.findViewById(R.id.textView));
            fruitImage.setImageResource(fruit.getImageId());
            fruitName.setText(fruit.getName());
        }
        return convertView;
    }
}
