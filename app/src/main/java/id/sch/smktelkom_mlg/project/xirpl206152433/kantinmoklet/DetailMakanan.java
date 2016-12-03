package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.food;



public class DetailMakanan extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final food Food = (food) getIntent().getSerializableExtra(id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.Food.FOOD);
        setTitle(Food.judulf);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFotoF);
        ivFoto.setImageURI(Uri.parse(Food.fotof));
        TextView tvDeskripsi = (TextView) findViewById(R.id.food_detail);
        tvDeskripsi.setText(Food.deskripsif + "\n\n");
        TextView tvLokasi = (TextView) findViewById(R.id.food_location);
        tvLokasi.setText(Food.lokasif);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
