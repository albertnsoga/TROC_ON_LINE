package com.google.firebase.quickstart.auth.troc_on_line.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.helper.DateTimePickerEditText;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.DatePicker;

import com.google.firebase.quickstart.auth.troc_on_line.Helpers.Utils;
import com.google.firebase.quickstart.auth.troc_on_line.Model.Troc;
import com.google.firebase.quickstart.auth.troc_on_line.R;
import com.google.firebase.quickstart.auth.troc_on_line.Retrofit.ResponseModel;
import com.google.firebase.quickstart.auth.troc_on_line.Retrofit.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CrudActivity extends AppCompatActivity {

/*
* on reference nos widgets ici
* */
    private TextView headerTxt;
    private EditText nameTxt, descriptionTxt;
    private DateTimePickerEditText dobTxt, dodTxt;
    private ProgressBar mProgressBar;
    private String id = null;
    private Troc receivedTroc;
    private Context c = CrudActivity.this;
    private void initializeWidgets(){
        mProgressBar = findViewById(R.id.mProgressBarSave);
        mProgressBar.setIndeterminate(true);
        mProgressBar.setVisibility(View.GONE);
        /**
         * pour les autres
         */
        headerTxt = findViewById(R.id.headerTxt);
        nameTxt = findViewById(R.id.nameTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);

        /*
        * on référence ici les widgets des dates*/
        dobTxt = findViewById(R.id.dobTxt);
        dobTxt.setFormat(Utils.DATE_FORMAT);
        dodTxt = findViewById(R.id.dodTxt);
        dodTxt.setFormat(Utils.DATE_FORMAT);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
    }
    /*
    * la méthode suivante nous permet insérer les données sur la page en bdd*/

    private  void insertDate(){
        String name, description, dob, dot;
        if(Utils.validate(nameTxt, descriptionTxt)){
            name = nameTxt.getText().toString();
            description = descriptionTxt.getText().toString();

            if(dobTxt.getDate() != null){
                dob = dobTxt.getDate().toString();
            } else {
                dobTxt.setError("Date invalide");
                dobTxt.requestFocus();
                return;
            }
            if(dodTxt.getDate() != null){
                dot = dodTxt.getDate().toString();
            }else {
                dodTxt.setError("heure invalide");
                dodTxt.requestFocus();
                return;
            }
            RestApi api = Utils.getClient().create(RestApi.class);
            Call<ResponseModel> insertData = api.insertData("INSERT", name, description, dob, dot);
            Utils.showProgressBar(mProgressBar);

            insertData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    Log.d("RETROFIT","response : "+ response.body().toString());
                    String myResponseCode = response.body().getCode();

                    if(myResponseCode.equals("1")){
                        Utils.show(c,"SUCCESS: \n 1. Data Inserted successfully. \n 2. ResponseCode:"
                          + myResponseCode);

                        Utils.openActivity(c, TrocActivity.class);
                    } else if(myResponseCode.equalsIgnoreCase("2")){
                        Utils.showInfoDialog(CrudActivity.this, "UNSUCCESSFUL", "However Good Response. \n 1. CONNECTION TO SERVER WAS SUCCESSFUL \n 2. WE" +
                                "ATTEMPTED POSTING DATA BUT ENCOUNTERED ResponseCode : "+ myResponseCode +" \n 3. Most probably the problem is with your php code");
                    }else if(myResponseCode.equalsIgnoreCase("3")){
                        Utils.showInfoDialog(CrudActivity.this, "No mysql connection" + "Your php code" +
                                "is unable to connect to mysql database");
                    }
                    Utils.hideProgressBar(mProgressBar);
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Log.d("RETROFIT", "ERROR: " + t.getMessage());
                    Utils.hideProgressBar(mProgressBar);
                    Utils.showInfoDialog(CrudActivity.this, "Failure", "Failure message: "+ t.getMessage());

                }
            });

        }

       }
    private void updateData(){
        String name, description, dob, dod;
        if(Utils.validate(nameTxt, descriptionTxt)){
            name = nameTxt.getText().toString();
            description = descriptionTxt.getText().toString();

            if(dobTxt.getDate() != null){
                dob = dobTxt.getFormat().format(dobTxt.getDate());
            } else {
                dobTxt.setError("Invalid Date");
                dobTxt.requestFocus();
                return;
            }
            if(dodTxt.getDate() != null){
                dod = dodTxt.getFormat().format(dodTxt.getDate());
            }else {
                dodTxt.setError("Invalid ....");
                dodTxt.requestFocus();
                return;
            }
            Utils.showProgressBar(mProgressBar);
        }
    }

}
