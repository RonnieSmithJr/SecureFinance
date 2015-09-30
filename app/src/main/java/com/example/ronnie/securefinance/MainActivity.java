package com.example.ronnie.securefinance;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity implements LocationListener, android.view.View.OnClickListener {
    private TextView latituteField;
    private TextView longitudeField;
    private LocationManager locationManager;
    private String provider;
    private int _UserInfo_Id=0;
    TextView userInfo_ID;


    Button submitButton;


    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latituteField = (TextView) findViewById(R.id.TextView02);
        longitudeField = (TextView) findViewById(R.id.TextView04);

        // Get the location manager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the locatioin provider -> use
        // default
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);

        // Initialize the location fields
        if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");
            onLocationChanged(location);
        } else {
            latituteField.setText("Location not available");
            longitudeField.setText("Location not available");
        }
    }

    /* Request updates at startup */
    @Override
    protected void onResume() {
        super.onResume();
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }

    /* Remove the locationlistener updates when Activity is paused */
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        int lat = (int) (location.getLatitude());
        int lng = (int) (location.getLongitude());
        latituteField.setText(String.valueOf(lat));
        longitudeField.setText(String.valueOf(lng));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider " + provider,
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
                Toast.LENGTH_SHORT).show();
    }

    public void submitName(View view){
        EditText editText = (EditText) findViewById(R.id.name);
        String showName = editText.getText().toString();

        Toast msg = Toast.makeText(getApplicationContext(), "Hi " + showName, Toast.LENGTH_SHORT);
        msg.show();

    }

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.submitButton)){

            Intent intent = new Intent(this,UserInfoDetail.class);
            intent.putExtra("userInfo_Id",0);
            startActivity(intent);

        }else {

            UserInfoRepo repo = new UserInfoRepo(this);

//            ArrayList<HashMap<String, String>> studentList =  repo.getUserInfoList();
//            if(studentList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                       // _UserInfo_Id = (TextView) view.findViewById(R.id.TextView01);
                        String userInfoID = userInfo_ID.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),UserInfoDetail.class);
                        objIndent.putExtra("userInfo_ID", Integer.parseInt( userInfoID));
                        startActivity(objIndent);
                    }
                });
//                ListAdapter adapter = new SimpleAdapter( MainActivity.this,studentList, R.layout.view_student_entry, new String[] { "id","name"}, new int[] {R.id.student_Id, R.id.student_name});
//                setListAdapter(adapter);
//            }else{
//                Toast.makeText(this,"No student!",Toast.LENGTH_SHORT).show();
//            }

        }
    }
}