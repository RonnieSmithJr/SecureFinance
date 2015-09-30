package com.example.ronnie.securefinance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ronnie on 9/28/15.
 */
public class UserInfoDetail extends ActionBarActivity implements android.view.View.OnClickListener{


    Button btnSubmit,  btnDelete;
    Button btnClose;
    EditText editTextBudget;
    EditText editTextBills;
    EditText editTextSavings;
    EditText editTextRent;
    private int _UserInfo_Id =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire);

        btnSubmit = (Button) findViewById(R.id.submitButton);
//        btnDelete = (Button) findViewById(R.id.btnDelete);
//        btnClose = (Button) findViewById(R.id.btnClose);

        editTextBudget = (EditText) findViewById(R.id.budget);
        editTextBills = (EditText) findViewById(R.id.bills);
        editTextSavings = (EditText) findViewById(R.id.savings);
        editTextRent = (EditText) findViewById(R.id.rent);

        btnSubmit.setOnClickListener(this);
//        btnDelete.setOnClickListener(this);
//        btnClose.setOnClickListener(this);


        _UserInfo_Id =0;
        Intent intent = getIntent();
        _UserInfo_Id =intent.getIntExtra("userInfo_Id", 0);
        UserInfoRepo repo = new UserInfoRepo(this);
        UserInfo userInfo = new UserInfo();
        userInfo = repo.getUserInfoById(_UserInfo_Id);

        editTextSavings.setText(String.valueOf(userInfo.savings));
        editTextBudget.setText(userInfo.budget);
        editTextBills.setText(userInfo.bills);
        editTextRent.setText(userInfo.rent);
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_detail, menu);
        return true;
    } */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClick(View view) {
        if (view == findViewById(R.id.budget)){
            UserInfoRepo repo = new UserInfoRepo(this);
            UserInfo userInfo = new UserInfo();
            userInfo.budget= Integer.parseInt(editTextBudget.getText().toString());
            userInfo.bills= Integer.parseInt(editTextBills.getText().toString());
            userInfo.savings= Integer.parseInt(editTextRent.getText().toString());
            userInfo.rent= Integer.parseInt(editTextRent.getText().toString());
            userInfo.user_ID= _UserInfo_Id;

            if (_UserInfo_Id ==0){
                _UserInfo_Id = repo.insert(userInfo);

                Toast.makeText(this, "New Student Insert", Toast.LENGTH_SHORT).show();
            }else{

                repo.update(userInfo);
                Toast.makeText(this,"Student Record updated",Toast.LENGTH_SHORT).show();
            }
        }
        /*else if (view== findViewById(R.id.btnDelete)){
            StudentRepo repo = new StudentRepo(this);
            repo.delete(_UserInfo_Id);
            Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }
        */


    }
}
