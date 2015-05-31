package com.irekasoft.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by hijazi on 31/5/15.
 */
public class MyDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Dialog myDialog = getDialog();
        myDialog.setTitle("title");

        LinearLayout linearLayout = new LinearLayout(getActivity());

        Button b = new Button(getActivity());
        b.setText("hello button");

        linearLayout.addView(b);

        return linearLayout;
    }
}
