package com.google.firebase.quickstart.auth.troc_on_line.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.quickstart.auth.troc_on_line.Helpers.Utils;
import com.google.firebase.quickstart.auth.troc_on_line.Model.Troc;
import com.google.firebase.quickstart.auth.troc_on_line.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    /* on doit définir nos instances
     */

    private TextView nameTxt, descriptionTxt;
    private FloatingActionButton editFAB;
    private Troc receivedTroc;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    /* on initialise nos widgets ici */
    private void initializeWidgets() {
        nameTxt = findViewById(R.id.nameTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        editFAB.setOnClickListener(this);
        mCollapsingToolbarLayout = findViewById(R.id.mCollapsingToolbarLayout);

    }

    /**
     * on va recevoir et montrer nos données
     */
    private void receiveAndShowData() {
        receivedTroc = Utils.receivedTroc(getIntent(), DetailActivity.this);
        if ( receivedTroc != null ) {
            nameTxt.setText(receivedTroc.getName());
            descriptionTxt.setText(receivedTroc.getDescription());
            mCollapsingToolbarLayout.setTitle(receivedTroc.getName());
            mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeWidgets();
        receiveAndShowData();
    }


    /*
     * let's inflate our menu for the detail page */

    public boolean onCrateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Utils.sendTrocToActivity(this, receivedTroc, CrudActivity.class);
                finish();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;
        }


    return super.onOptionsItemSelected(item);
}
    @Override
    public void onClick(View v) {
        int id =v.getId();
        if(id == R.id.editFAB){
            Utils.sendTrocToActivity(this,receivedTroc, CrudActivity.class);
            finish();
    }


    }
    /*
     * let's finish the current activity when back button is pressed  */
    @Override

    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}