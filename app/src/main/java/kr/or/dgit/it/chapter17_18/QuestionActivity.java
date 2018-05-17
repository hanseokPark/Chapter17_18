package kr.or.dgit.it.chapter17_18;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuestionActivity extends AppCompatActivity implements QuestionDialogFragment.NoticeDialogListener {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setTitle(getIntent().getStringExtra("title"));

        tv = findViewById(R.id.tvResult);


    }

    @Override
    public void onDialogClick(DialogFragment dialog, int res) {
        tv.setText("연산 결과 = " + res);
        Toast.makeText(this, "연산을 완료하였습니다", Toast.LENGTH_SHORT).show();
    }

    public void mOpenDigClick(View view){
        QuestionDialogFragment newFragment = new QuestionDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title","질문");
        bundle.putString("msg","어떤 연산을 하시겠습니까?");
        bundle.putString("Q1","덧셈");
        bundle.putString("Q2","곱셈");
        bundle.putInt("a",3);
        bundle.putInt("b",4);
        newFragment.setArguments(bundle);
        newFragment.show(getSupportFragmentManager(), "Dialog");
    }

}
