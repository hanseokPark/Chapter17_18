package kr.or.dgit.it.chapter17_18;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentManagerActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;
    private Button showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manager);
        setTitle(getIntent().getStringExtra("title"));



        mFragmentManager = getSupportFragmentManager();


        showBtn = findViewById(R.id.btnHide);
    }

    public void btnAddClick(View view) {
        Fragment fragment = mFragmentManager.findFragmentById(R.id.frame);
        if(fragment == null){
            FragmentLifeCycleActivity.CounterFragment cf = new FragmentLifeCycleActivity.CounterFragment();
            mFragmentManager.beginTransaction().add(R.id.frame, cf, "cntFrag").commit();
        }else{
            showToast("이미 추가 되었습니다.");
        }
    }

    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void btnRemoveClick(View view) {
        Fragment fragment = mFragmentManager.findFragmentById(R.id.frame);
        if(fragment == null){
            showToast("삭제할 프래그먼트가 존재하지 않음");
        }else {
            mFragmentManager.beginTransaction().remove(fragment).commit();
        }
    }

    public void btnReplaceClick(View view) {
        Fragment fragment = mFragmentManager.findFragmentById(R.id.frame);
        if(fragment == null){
            showToast("교체할 프래그먼트가 존재하지 않음");
        }else{
            if(fragment.getTag().equals("cntFrag")){
                TextFragment txtFrag = new TextFragment();
                mFragmentManager.beginTransaction().replace(R.id.frame, txtFrag, "txtFrag").commit();
            }else{
                FragmentLifeCycleActivity.CounterFragment cf = new FragmentLifeCycleActivity.CounterFragment();
                mFragmentManager.beginTransaction().replace(R.id.frame, cf, "cntFrag").commit();
            }
        }
    }

    public void btnHideClick(View view) {
        Fragment fragment = mFragmentManager.findFragmentById(R.id.frame);
        if(fragment == null){
            showToast("프래이그먼트가 존재하지 않음");
        }else{
            if(fragment.isHidden()){
                mFragmentManager.beginTransaction().show(fragment).commit();
                showBtn.setText("Hide");
            }else{
                mFragmentManager.beginTransaction().hide(fragment).commit();
                showBtn.setText("Show");
            }
        }
    }

    public static class TextFragment extends Fragment{
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_test, container, false);
            return root;
        }
    }
}
