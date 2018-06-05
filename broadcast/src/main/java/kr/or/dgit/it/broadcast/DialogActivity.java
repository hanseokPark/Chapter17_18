package kr.or.dgit.it.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogActivity extends Activity implements View.OnClickListener{
    ImageView  finishBtn;
    TextView numberView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        numberView = findViewById(R.id.lab1_phone_number);
        finishBtn = findViewById(R.id.lab1_remove_icon);

        finishBtn.setOnClickListener(this);

        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        numberView.setText(number);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
