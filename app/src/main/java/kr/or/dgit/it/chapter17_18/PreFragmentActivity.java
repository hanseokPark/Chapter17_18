package kr.or.dgit.it.chapter17_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_fragment);
        setTitle(getIntent().getStringExtra("title"));

        FragmentPref fragmentPref = new FragmentPref();
        getFragmentManager().beginTransaction().add(R.id.frame, fragmentPref).commit();
    }
}
