package kr.or.dgit.it.chapter17_18;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MultiDescFragment extends Fragment {
    int mNowIdex;

    public static MultiDescFragment newInstance(int selectedindex){
        MultiDescFragment mdf = new MultiDescFragment();
        mdf.mNowIdex = selectedindex;
        return mdf;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String[] planetDescs = getResources().getStringArray(R.array.planet_desc);

        View root = inflater.inflate(R.layout.fragment_multi_desc, container, false);
        TextView tv = root.findViewById(R.id.planet_desc);
        tv.setText(planetDescs[mNowIdex]);

        return root;

    }
}
