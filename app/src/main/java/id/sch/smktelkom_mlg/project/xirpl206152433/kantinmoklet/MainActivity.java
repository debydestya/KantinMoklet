package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper) this.findViewById(R.id.viewFlipper);
        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(2300);
    }

    public void list_food(View view) {
        startActivity(new Intent(MainActivity.this, Food.class));
    }

    public void list_drink(View view) {
        startActivity(new Intent(MainActivity.this, Drink.class));
    }
}
