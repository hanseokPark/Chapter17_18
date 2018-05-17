package kr.or.dgit.it.chapter17_18;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);
        setTitle(getIntent().getStringExtra("title"));

        WordListFragment wordListFragment = new WordListFragment();
        getSupportFragmentManager().beginTransaction().add(android.R.id.content, wordListFragment).commit();

    }


    @SuppressLint("ValidFragment")
    public static class  WordListFragment extends ListFragment{

        private String[] desc;
        private  String[] words;

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            words = getResources().getStringArray(R.array.word);
            desc = getResources().getStringArray(R.array.word_desc);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, words);
            setListAdapter(adapter);

        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Toast.makeText(getActivity(), words[position] + ":" + desc[position], Toast.LENGTH_SHORT).show();

        }
    }
}
