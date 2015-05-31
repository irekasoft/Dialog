package com.irekasoft.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Created by hijazi on 31/5/15.
 */
public class MyTimePickerDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), timeSetListener, 23,10, true);

        return timePickerDialog;

    }

    TimePickerDialog.OnTimeSetListener timeSetListener =
    new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // set time here
            Log.i("hi", "time changes");

        }
    };

}
