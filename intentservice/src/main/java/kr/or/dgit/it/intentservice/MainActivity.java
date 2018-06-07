package kr.or.dgit.it.intentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TabHost.OnTabChangeListener{
    TabHost host;
    ListView serviceListView;
    ListView appListView;
    ListView pinkListView;

    ArrayList<HashMap<String, String>> appsDatas;
    ArrayList<HashMap<String, String>> serviceDatas;

    SimpleAdapter appsAdapter;
    SimpleAdapter serviceAdapter;
    SimpleAdapter pickAdapter;

    Button alarmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        host = findViewById(R.id.lab3_host);
        serviceListView = findViewById(R.id.lab3_service);
        appListView = findViewById(R.id.lab3_apps);
        pinkListView = findViewById(R.id.lab3_pick);
        alarmBtn = findViewById(R.id.lab3_btn);

        host.setup();
        host.setOnTabChangedListener(this);
        alarmBtn.setOnClickListener(this);

        TabHost.TabSpec spec = host.newTabSpec("tab1");
        spec.setIndicator("service");
        spec.setContent(R.id.lab3_service);
        host.addTab(spec);

        spec = host.newTabSpec("tab2");
        spec.setIndicator("apps");
        spec.setContent(R.id.lab3_apps);
        host.addTab(spec);

        spec = host.newTabSpec("tab3");
        spec.setIndicator("action : PICK");
        spec.setContent(R.id.lab3_pick);
        host.addTab(spec);

        registerReceiver(receiver, new IntentFilter("com.example.ACTION_TO_ACTIVITY"));



    }
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainActivity.this, intent.getStringExtra("message"), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onTabChanged(String tabId) {

    }
}
