package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.adapter.FavoriteAdapter;
import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.Favorite;
import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.drink;
import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.food;

public class MainActivity extends AppCompatActivity {

    ListView lvFav;
    public static food iFood;
    public static drink iDrink;
    public static ArrayList<Favorite> arrayfav = new ArrayList<Favorite>();
    public static FavoriteAdapter adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvFav = (ListView) findViewById(R.id.lvFav);
        adapter = new FavoriteAdapter(this, arrayfav);
        lvFav.setAdapter(adapter);
        Intent i = getIntent();
        try {
            if (!i.getStringExtra("favName").equals("") || !i.getStringExtra("favPicture").equals("")) {
                food iFood = (food) i.getSerializableExtra(id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.Food.FOOD);
                drink iDrink = (drink) i.getSerializableExtra(id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.Drink.DRINK);
                Log.d("APP", iFood.judulf);
                if(!iFood.judulf.equals("")){
                    adapter.add(new Favorite(i.getStringExtra("favName"), i.getStringExtra("favPicture"), iFood));
                }
                if(!iDrink.judul.equals("")){
                    adapter.add(new Favorite(i.getStringExtra("favName"), i.getStringExtra("favPicture"), iDrink));
                }
                adapter.notifyDataSetChanged();
            }
        } catch (Exception ex) {

        }
    }

    public void list_food(View view) {
        startActivity(new Intent(MainActivity.this, Food.class));
    }

    public void list_drink(View view) {
        startActivity(new Intent(MainActivity.this, Drink.class));
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
