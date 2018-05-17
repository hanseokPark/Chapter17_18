package kr.or.dgit.it.chapter17_18;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends android.support.v4.app.Fragment {

    public static CounterFragment newInstance(int start){
        CounterFragment cf= new CounterFragment();
        Bundle args = new Bundle();
        args.putInt("start",start);
        cf.setArguments(args);
        return cf;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_counter, container, false);
        final TextView cntTextView = root.findViewById(R.id.txtCounter);
        if(savedInstanceState != null){
            cntTextView.setText(String.valueOf(savedInstanceState.getInt("counter")));
        }

        Bundle args = getArguments();
        if(args != null){
            int start = args.getInt("start");
            cntTextView.setText(String.valueOf(start));
        }
        Button btnlncrease = root.findViewById(R.id.btnlncrease);
        btnlncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(cntTextView.getText().toString());
                cntTextView.setText(String.valueOf(count+1));
            }
        });
        return root;
    }
}
