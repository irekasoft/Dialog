package com.irekasoft.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

// sambung
// lagi
// http://www.i-programmer.info/programming/android/7530-android-adventures-dialog-classes-in-dialogfragments.html?start=1
public class MainActivity extends ActionBarActivity implements CustomDialogFragment.DialogDoneListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //region CustomDialogFragment.DialogDoneListener
    @Override
    public void onDone(boolean state) {
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(Boolean.toString(state));

        Log.i("here", "done");

    }
    //endregion

    //region Actions

    public void showMyDialog(View view) {
        MyDialog myDialog = new MyDialog();
        myDialog.show(getFragmentManager(), "Diag");

    }

    public void showDialogFragment(View view){
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getFragmentManager(),"Dia");

    }

    public void showCustomDialog(View view){

        CustomDialogFragment customDialogFragment = new CustomDialogFragment();

        // Fragmentation
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.addToBackStack(null);
//        ft.replace(R.id.container,customDialogFragment,"dia");
//        ft.commit();


        customDialogFragment.show(getFragmentManager(), "Hi");

    }

    public void showSimpleDialog(View view){

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Alert message to be shown");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }

    public void showFluentAlert(View view){
        AlertDialog myAlert=
                new AlertDialog.Builder(this)
                        .setTitle("My Alert Dialog")
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(
                                            DialogInterface dialog, int which) {
                                        //do something as Ok button clicked
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(
                                            DialogInterface dialog, int which) {
                                        //do something as Cancel button clicked
                                    }
                                })
                        .create();
        myAlert.show();
    }

    //endregion

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
