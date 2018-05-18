package kr.or.dgit.it.chapter17_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import kr.or.dgit.it.chapter17_18.R;

public class MainActivity extends AppCompatActivity {
    private String[] titles;
    private String[] activities;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles = getResources().getStringArray(R.array.titles);
        //원본
        activities = getResources().getStringArray(R.array.activities);
        //어뎁터
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titles);
        //리스트 뷰
        listView = findViewById(R.id.listView);
        //리스트뷰와 어뎁터 연결
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClassName(getPackageName(), getPackageName() + "."+activities[position]);
                intent.putExtra("title", titles[position]);
                startActivity(intent);

            }
        });
    }
}
