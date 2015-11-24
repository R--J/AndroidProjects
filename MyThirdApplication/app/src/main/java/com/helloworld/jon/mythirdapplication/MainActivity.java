package com.helloworld.jon.mythirdapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit("apple", R.drawable.apple));
        fruits.add(new Fruit("banana", R.drawable.banana));
        fruits.add(new Fruit("cherry", R.drawable.cherry));
        fruits.add(new Fruit("coco", R.drawable.coco));
        fruits.add(new Fruit("kiwi", R.drawable.kiwi));
        fruits.add(new Fruit("orange", R.drawable.orange));
        fruits.add(new Fruit("pear", R.drawable.pear));
        fruits.add(new Fruit("strawberry", R.drawable.strawberry));
        fruits.add(new Fruit("watermelon", R.drawable.watermelon));
        FruitAdapter myFruitAdapter = new FruitAdapter(MainActivity.this, R.id.listView, fruits);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myFruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("fruitName", (((FruitAdapter)listView.getAdapter()).getItem(position)).getName());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                FruitAdapter adapter = (FruitAdapter)listView.getAdapter();
                Fruit fruit = adapter.getItem(position);
                fruits.remove(fruit);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
