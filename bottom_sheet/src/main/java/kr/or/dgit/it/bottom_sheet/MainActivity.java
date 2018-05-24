package kr.or.dgit.it.bottom_sheet;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    CoordinatorLayout coordinatorLayout;
    private BottomSheetBehavior<View> persistentBottomSheet;
    private BottomSheetDialog modalBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        coordinatorLayout = findViewById(R.id.lab4_coordinator);
        btn = findViewById(R.id.lab4_button);
        btn.setOnClickListener(this);

        initPersistentBottomSheet();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        createDialog();
    }

    private void createDialog() {
        List<DataVO> list = new ArrayList<>();

        DataVO vo = new DataVO();
        vo.title = "Keep";
        vo.image = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_1, null);
        list.add(vo);

        vo = new DataVO();
        vo.title = "Inbox";
        vo.image = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_2, null);
        list.add(vo);

        vo = new DataVO();
        vo.title = "Messanger";
        vo.image = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_3, null);
        list.add(vo);

        vo = new DataVO();
        vo.title = "Google+";
        vo.image = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_4, null);
        list.add(vo);

        Lab4RecyclerViewAdapter adapter = new Lab4RecyclerViewAdapter(list);
        View view = getLayoutInflater().inflate(R.layout.modal_sheet, null);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        modalBottomSheet = new BottomSheetDialog(this);
        modalBottomSheet.setContentView(view);
        modalBottomSheet.show();
    }


    private void initPersistentBottomSheet() {
        View bottomSheet = coordinatorLayout.findViewById(R.id.lab4_bottom_sheet);
        persistentBottomSheet = BottomSheetBehavior.from(bottomSheet);
    }
}
