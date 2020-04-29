package com.google.firebase.quickstart.auth.troc_on_line.Views;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.quickstart.auth.troc_on_line.Helpers.Utils;

import java.io.File;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

class BaseActivity extends AppCompatActivity {

    protected void show(String message){
        Utils.show(this,message);
    }
    protected void openPage(Class clazz){
        Utils.openActivity(this,clazz);
    }

    protected boolean validate(File file, boolean isFileRequired, EditText... editTexts){
        EditText nameTxt = editTexts[0];
        EditText descriptionTxt = editTexts[1];
        EditText galaxyTxt = editTexts[2];

        if(file == null && isFileRequired){
            Utils.show(this,"Image is required");
            return false;
        }
        if(nameTxt.getText() == null || nameTxt.getText().toString().isEmpty()){
            nameTxt.setError("Name is Required Please!");
            return false;
        }
        if(descriptionTxt.getText() == null || descriptionTxt.getText().toString().isEmpty()){
            descriptionTxt.setError("Description is Required Please!");
            return false;
        }
        if(galaxyTxt.getText() == null || galaxyTxt.getText().toString().isEmpty()){
            galaxyTxt.setError("Galaxy is Required Please!");
            return false;
        }
        return true;

    }
    protected void clearEditTexts(EditText... editTexts){
        for (EditText editText:editTexts) {
            editText.setText("");
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

   /* @Override
    public void onBackPressed() {
        super.onBackPressed();
        if( this instanceof UploadActivity){
            Utils.showInfoDialog(this,"GOING BACK","Are you sure you want to exit this page");
        }else{
            this.finish();
        }
    }*/
   /* protected void captureImage(){
        Intent i = new Intent(this, ImageSelectActivity.class);
        i.putExtra(ImageSelectActivity.FLAG_COMPRESS, false);//default is true
        i.putExtra(ImageSelectActivity.FLAG_CAMERA, true);//default is true
        i.putExtra(ImageSelectActivity.FLAG_GALLERY, true);//default is true
        startActivityForResult(i, 1213);
    }*/
}
