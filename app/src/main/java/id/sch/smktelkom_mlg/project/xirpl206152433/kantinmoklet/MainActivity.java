package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
}
