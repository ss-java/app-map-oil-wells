package com.lustrel.geoaccess.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.lustrel.geoaccess.R;
import org.json.JSONException;
import org.json.JSONObject;

public class OilDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView lblOwner;
    private TextView lblLatitude;
    private TextView lblLongitude;
    private TextView lblState;
    private TextView lblBasin;
    private TextView lblField;
    private TextView lblLocation;
    private TextView lblDrillingYear;
    private TextView lblFinishDrilling;
    private TextView lblCategory;
    private TextView lblKind;
    private TextView lblReclassification;
    private TextView lblDepth;
    private TextView lblDrill;
    private TextView lblGeneratingRock;
    private TextView lblSealsAndReservoirRocks;
    private TextView lblGenerationAndMigration;
    private TextView lblTraps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oil_details_activity);
        loadElementsFromXML();
        applyToolbar();
        populateDetails();
    }

    private void loadElementsFromXML(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        lblOwner = (TextView) findViewById(R.id.owner);
        lblLatitude = (TextView) findViewById(R.id.latitude);
        lblLongitude = (TextView) findViewById(R.id.longitude);
        lblState = (TextView) findViewById(R.id.state);
        lblBasin = (TextView) findViewById(R.id.basin);
        lblField = (TextView) findViewById(R.id.field);
        lblLocation = (TextView) findViewById(R.id.location);
        lblDrillingYear = (TextView) findViewById(R.id.drilling_year);
        lblFinishDrilling = (TextView) findViewById(R.id.finish_drilling);
        lblCategory = (TextView) findViewById(R.id.category);
        lblKind = (TextView) findViewById(R.id.kind);
        lblReclassification = (TextView) findViewById(R.id.reclassification);
        lblDepth = (TextView) findViewById(R.id.depth);
        lblDrill = (TextView) findViewById(R.id.drill);
        lblGeneratingRock = (TextView) findViewById(R.id.generating_rock);
        lblSealsAndReservoirRocks = (TextView) findViewById(R.id.seals_and_reservoir_rocks);
        lblGenerationAndMigration = (TextView) findViewById(R.id.generation_and_migration);
        lblTraps = (TextView) findViewById(R.id.traps);
    }

    private void applyToolbar(){
        setSupportActionBar(toolbar);
    }

    private void populateDetails(){
        try {
            String detailsAsText = getIntent().getStringExtra("MARKER_DETAILS");
            JSONObject details = new JSONObject(detailsAsText);

            setTitle(details.getString("name"));
            if(details.has("operator"))
                lblOwner.setText(getString(R.string.detail_owner_text) + " " + details.getString("operator"));
            if(details.has("latitude"))
                lblLatitude.setText(getString(R.string.detail_latitude_text) + " " + details.getString("latitude"));
            if(details.has("longitude"))
                lblLongitude.setText(getString(R.string.detail_longitude_text) + " " + details.getString("longitude"));
            if(details.has("state"))
                lblState.setText(getString(R.string.detail_state_text) + " " + details.getString("state"));
            if(details.has("basin"))
                lblBasin.setText(getString(R.string.detail_basin_text) + " " + details.getString("basin"));
            if(details.has("field"))
                lblField.setText(getString(R.string.detail_field_text) + " " + details.getString("field"));
            if(details.has("location"))
                lblLocation.setText(getString(R.string.detail_location_text) + " " + details.getString("location"));
            if(details.has("drillingYear"))
                lblDrillingYear.setText(getString(R.string.detail_drilling_year_text) + " " + details.getString("drillingYear"));
            if(details.has("finishDrilling"))
                lblFinishDrilling.setText(getString(R.string.detail_finish_drilling_text) + " " + details.getString("finishDrilling"));
            if(details.has("category"))
                lblCategory.setText(getString(R.string.detail_category_text) + " " + details.getString("category"));
            if(details.has("kind"))
                lblKind.setText(getString(R.string.detail_kind_text) + " " + details.getString("kind"));
            if(details.has("reclassification"))
                lblReclassification.setText(getString(R.string.detail_reclassification_text) + " " + details.getString("reclassification"));
            if(details.has("depth"))
                lblDepth.setText(getString(R.string.detail_depth_text) + " " + details.getString("depth"));
            if(details.has("drill"))
                lblDrill.setText(getString(R.string.detail_drill_text) + " " + details.getString("drill"));
            if(details.has("generatingRock"))
                lblGeneratingRock.setText(getString(R.string.detail_generating_rock) + "\n" + details.getString("generatingRock"));
            if(details.has("sealsAndReservoirRocks"))
                lblSealsAndReservoirRocks.setText(getString(R.string.detail_seals_and_reservoir_rocks) + "\n" + details.getString("sealsAndReservoirRocks"));
            if(details.has("generationAndMigration"))
                lblGenerationAndMigration.setText(getString(R.string.detail_generation_and_migration) + "\n" + details.getString("generationAndMigration"));
            if(details.has("traps"))
                lblTraps.setText(getString(R.string.detail_traps) + "\n" + details.getString("traps"));
        } catch(JSONException exception){}
    }
}
