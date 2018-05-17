package kr.or.dgit.it.chapter17_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DividFragmentActivity extends AppCompatActivity implements WordListFragmentDivide.OnWordChangeListener {
    TextView wordDesc;
    String[] desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divid_fragment);
        setTitle(getIntent().getStringExtra("title"));

        wordDesc = findViewById(R.id.wordDec);
        desc = getResources().getStringArray(R.array.word_desc);




    }

    @Override
    public void onWordChanged(int index) {
        wordDesc.setText(desc[index]);
    }
}
