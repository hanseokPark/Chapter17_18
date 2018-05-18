package kr.or.dgit.it.chapter17_18;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MultiDescActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        int index = getIntent().getExtras().getInt("selectedindex");
        MultiDescFragment df = MultiDescFragment.newInstance(index);

        getSupportFragmentManager().beginTransaction().add(android.R.id.content, df).commit();

    }
}
