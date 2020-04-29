package com.google.firebase.quickstart.auth.troc_on_line.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.quickstart.auth.troc_on_line.Helpers.Utils;
import com.google.firebase.quickstart.auth.troc_on_line.Model.Troc;
import com.google.firebase.quickstart.auth.troc_on_line.R;

public class DashboardActivity extends AppCompatActivity {

    /*
    * on déclare nos variables  (qui sont des widgets) ici*/
    LinearLayout viewTrocCard;
    LinearLayout addTrocCard;
    LinearLayout third;
    LinearLayout closeTrocCard;




    /*
     * on initialise nos variables ici dans une méthode private void initializeWidget(){};*/
    private void initializeWidgets(){
        viewTrocCard = findViewById(R.id.viewTrocCard);
        addTrocCard = findViewById(R.id.addTrocCard);
        third = findViewById(R.id.third);
        closeTrocCard = findViewById(R.id.closeTrocCard);

        /*
         * on définit les méthodes qui animent nos objets ici*/

        viewTrocCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Utils.openActivity(DashboardActivity.this, TrocActivity.class);
            }
        });
        addTrocCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,CrudActivity.class);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showInfoDialog(DashboardActivity.this, "tu peux ouvrir une autre page en cliquant ici!!");
            }
        });
        closeTrocCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override

    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));

    }
    /**
     * when the pressed button is pressed, finish this activity
     */

@Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
}
@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.initializeWidgets();

}
/**
 * this the end of our dashboard activity
 */









    }

