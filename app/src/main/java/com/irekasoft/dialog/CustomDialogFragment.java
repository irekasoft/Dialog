package com.irekasoft.dialog;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

/**
 * Created by hijazi on 31/5/15.
 */
public class CustomDialogFragment extends DialogFragment{

    private boolean m_status;
    private DialogDoneListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.custom_dialog, container, false);

//        Dialog myDialogue = getDialog();
//        myDialogue.setTitle("My Dialog");
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);


        Button btn_ok = (Button)v.findViewById(R.id.button);
        btn_ok.setOnClickListener(onCancel);

        Button btn_cancel = (Button)v.findViewById(R.id.button2);
        btn_cancel.setOnClickListener(onOK);



        return v;

    }

    View.OnClickListener onCancel=
            new View.OnClickListener()
     {
        @Override
        public void onClick(View view){
            m_status=false;
            mListener.onDone(m_status);
            dismiss();
        }
    };

    View.OnClickListener onOK=
            new View.OnClickListener()
    {
        @Override public void onClick(View view){
            m_status=true;
            mListener.onDone(m_status);
            dismiss();
        }
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (DialogDoneListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement dialogDoneistener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface DialogDoneListener{
        void onDone(boolean state);
    }

}
