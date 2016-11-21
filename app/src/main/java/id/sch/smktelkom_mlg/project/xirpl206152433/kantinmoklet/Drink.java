package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.adapter.drinkadapter;
import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.drink;


public class Drink extends AppCompatActivity implements drinkadapter.IdrinkAdapter
{

    public static final String DRINK = "drink";
    ArrayList<drink> mList = new ArrayList<>();
    drinkadapter mAdapter;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewDrink);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new drinkadapter(this,mList);
        recyclerView.setAdapter(mAdapter);
        
        fillData();

    }

    private void fillData()
    {
        Resources resources = getResources();
        String [] arJudul = resources.getStringArray(R.array.drink);
        String [] arDeskripsi = resources.getStringArray(R.array.drink_desc);
        String [] arLokasi = resources.getStringArray(R.array.drink_locations);
        TypedArray a = resources.obtainTypedArray(R.array.drink_picture);
        String [] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++)
        {
            int id = a.getResourceId(i,0);

            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE+"://"
                +resources.getResourcePackageName(id)+'/'
                +resources.getResourceTypeName(id)+'/'
                +resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++)
        {
            mList.add(new drink(arJudul[i],arDeskripsi[i],arLokasi[i],arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void doClick(int pos)
    {
        Intent intent = new Intent(this, DetailMinuman.class);
        intent.putExtra(DRINK,mList.get(pos));
        startActivity(intent);
    }
}
