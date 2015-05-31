package com.irekasoft.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Date;

/**
 * Created by hijazi on 31/5/15.
 */
public class MyDatePickerDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), dateSetListener,2015,5,30);

        return datePickerDialog;

    }

    DatePickerDialog.OnDateSetListener dateSetListener =
    new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view,
                              int year,
                              int monthOfYear,
                              int dayOfMonth) {
            // date changes
            Log.i("hi", "date changes");

        }
    };

}
