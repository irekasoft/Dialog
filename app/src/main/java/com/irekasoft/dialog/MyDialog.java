package com.irekasoft.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by hijazi on 29/5/15.
 */
public class MyDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());
        myBuilder.setTitle("Alert");
        myBuilder.setMessage("This is my message");

        myBuilder.setPositiveButton("OK", event_ok);
        myBuilder.setNegativeButton("Cancel", event_cancel);

        AlertDialog myAlert = myBuilder.create();

        return myAlert;
    }

    DialogInterface.OnClickListener event_ok =
            new DialogInterface.OnClickListener(){
        @Override
        public void onClick(
                DialogInterface dialog, int which) {
            //do something
            Log.i("return","ok");
        }
    };

    DialogInterface.OnClickListener event_cancel =
            new DialogInterface.OnClickListener(){
        @Override
        public void onClick(
                DialogInterface dialog, int which) {
            //do something
            Log.i("return","cancel");
        }
    };


}