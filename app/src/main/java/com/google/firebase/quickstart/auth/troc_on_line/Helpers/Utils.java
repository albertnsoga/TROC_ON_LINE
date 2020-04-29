package com.google.firebase.quickstart.auth.troc_on_line.Helpers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.quickstart.auth.troc_on_line.Model.Troc;
import com.google.firebase.quickstart.auth.troc_on_line.Views.CrudActivity;
import com.google.firebase.quickstart.auth.troc_on_line.Views.DashboardActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utils {

    private static final String base_url = "http://DESKTOP-PIVST4C/projet/magasin/TROC";
    public static Retrofit retrofit;
    public static final String DATE_FORMAT = "yyyy-MM-dd";


    public static Retrofit getClient() {
        if ( retrofit == null ) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;


    }
    /**
     *
     * this method will allow us show toast messages throughout all activities
     */
    public static  void show (Context c,String message){
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }
    /**
     * this method will allow us validate editExt
     */
    public static boolean validate(EditText... editTexts) {
        EditText nameTxt = editTexts[0];
        EditText descriptionTxt = editTexts[1];
        EditText galaxyTxt = editTexts[2];
        if ( nameTxt.getText() == null || nameTxt.getText().toString().isEmpty() ) {
            nameTxt.setError("Name is Required please");
            return false;
        }
        if ( descriptionTxt.getText() == null || descriptionTxt.getText().toString().isEmpty() ) {
            descriptionTxt.setError("description is Required please");
            return false;
        }
        if ( galaxyTxt.getText() == null || galaxyTxt.getText().toString().isEmpty() ) {
            galaxyTxt.setError("Galaxy is Required please");
            return false;
        }

            return true;
    }
    /**
     * this utility method will allow us clear arbitrary number of
     */

    public static  void clearEditText(EditText...editTexts){
        for (EditText editText:editTexts){
            editText.setText("");
        }

    }
    /** this method will allow us open any activity
     *
     */
    public static void  openActivity(Context c,Class clazz){
        Intent intent = new Intent(c, clazz);
        c.startActivity(intent);
    }
    /**
     * this method will help to show an info dialog anywhere in our app
     */
  /**
    public static void showInfodialog(final AppCompatActivity activity,String title, String message){
        new LoveLyStandardDialog(activity, LoveLyStandarddialog.ButtonLayout.HORIZONTAL){
            .set
        }
    }*/
  public static Date giveMeDate(String stringDate){
      try{
          SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
          return sdf.parse(stringDate);
      }catch (ParseException e){
          e.printStackTrace();
          return null;
      }
  }
    /**
     * this method will allow us to show a progressBar
     */
    public static void showProgressBar(ProgressBar pb){
        pb.setVisibility(View.VISIBLE);
    }

    /**
     * this method will allow us to hide a progress Bar
     *
     */
    public static void hideProgressBar(ProgressBar pb){
        pb.setVisibility(View.GONE);
    }

    /**
     * this will help us send a serialized troc object to a specified activity
     */

    public static void  sendTrocToActivity(Context c, Troc troc, Class clazz){
        Intent i = new Intent(c,clazz);
        i.putExtra("TROC_KEY", troc);
        c.startActivity(i);
    }
    public static Troc receivedTroc(Intent intent,Context c){
        try {
            Troc troc = (Troc) intent.getSerializableExtra("TROC_KEY");
            return troc;
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-TROC ERROR: "+e.getMessage());
        }
        return null;
    }

    public static void showInfoDialog(CrudActivity dashboardActivity, String ok_) {
    }

    public static void showInfoDialog(DashboardActivity dashboardActivity, String s) {
    }

    public static void showInfoDialog(CrudActivity crudActivity, String unsuccessful, String s) {
    }
}
