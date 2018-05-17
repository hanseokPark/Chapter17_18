package kr.or.dgit.it.chapter17_18;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class QuestionDialogFragment extends DialogFragment {
    NoticeDialogListener mListener;
    Bundle bundle;

    public interface NoticeDialogListener{
        public void onDialogClick(DialogFragment dialog, int res);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (NoticeDialogListener) context;
        }catch (ClassCastException e){
            String msg = " must implement NoticeDialogListener";
            throw new ClassCastException(context.toString()+msg);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        Bundle bundle = getArguments();
        final int a = bundle.getInt("a");
        final int b = bundle.getInt("b");

        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(bundle.getString("title"))
                .setMessage(bundle.getString("msg"))
                .setPositiveButton(bundle.getString("Q1"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogClick(QuestionDialogFragment.this, a + b);
                    }
                })
                .setNegativeButton(bundle.getString("Q2"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogClick(QuestionDialogFragment.this, a*b);
                    }
                })
                .create();

    }
}
