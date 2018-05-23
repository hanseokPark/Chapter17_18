package kr.or.dgit.it.recyclerview_cardview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {


    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        final DrawerLayout drawerLayout = findViewById(R.id.main_drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.main_drawer_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id==R.id.menu_drawer_home){
                    showToast("NavigationDrawer...home..");
                }else if(id==R.id.menu_drawer_message){
                    showToast("NavigationDrawer...message..");
                }else if(id==R.id.menu_drawer_add){
                    showToast("NavigationDrawer...add..");
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;

            }

        });



        //원본
        Item[] items = {
                new Item("Chapter One", "Item one details", R.drawable.android_image_1),
                new Item("Chapter Two", "Item Two details", R.drawable.android_image_2),
                new Item("Chapter Three", "Item Three details", R.drawable.android_image_3),
                new Item("Chapter Four", "Item Four details", R.drawable.android_image_4),
                new Item("Chapter Five", "Item Five details", R.drawable.android_image_5),
                new Item("Chapter Six", "Item Six details", R.drawable.android_image_6),
                new Item("Chapter Seven", "Item Seven details", R.drawable.android_image_7),
                new Item("Chapter Eight", "Item Eight details", R.drawable.android_image_8),
        };

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        /*RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(this, 2);
        RecyclerView.LayoutManager layoutManager2 = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);*/

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(items));

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
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return false;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private class RecyclerAdapter extends RecyclerView.Adapter {
        Item[] items;

        public RecyclerAdapter(Item[] items) {
            this.items = items;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;

            Item item = items[position];

            viewHolder.itemTitle.setText(item.title);
            viewHolder.itemDetail.setText(item.detail);
            viewHolder.itemImage.setImageResource(item.img);
        }

        @Override
        public int getItemCount() {
            return items.length;
        }


        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView itemImage;
            TextView itemTitle;
            TextView itemDetail;

            public ViewHolder(View itemView) {
                super(itemView);
                itemImage = itemView.findViewById(R.id.item_image);
                itemTitle = itemView.findViewById(R.id.item_title);
                itemDetail = itemView.findViewById(R.id.item_detail);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        Snackbar.make(v, "Click selected on Item" + position, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        }
    }
}
