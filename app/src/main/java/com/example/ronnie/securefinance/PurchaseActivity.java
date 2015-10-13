package com.example.ronnie.securefinance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class PurchaseActivity extends AppCompatActivity {
public ArrayList<Purchase> purchases = new ArrayList<Purchase>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        setContentView(R.layout.activity_purchase);
        EditText budget = (EditText) findViewById(R.id.amount);
        budget.setText("Enter amount of purchase");

        EditText bills = (EditText) findViewById(R.id.description);
        bills.setText("Enter description of your purchase");

        Bundle bundle = getIntent().getExtras();

        purchases = bundle.getParcelableArrayList("purchaces");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_purchase, menu);
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

    public void submitPurchase(View v){
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        EditText purchaseAmount = (EditText) findViewById(R.id.amount);
        int amount =  Integer.parseInt(purchaseAmount.getText().toString());

        EditText purchaseDescription = (EditText) findViewById(R.id.description);
        String description = purchaseDescription.getText().toString();

        EditText purchaseLocation = (EditText) findViewById(R.id.location);
        String location = purchaseLocation.getText().toString();

        Purchase p = new Purchase(amount,description, location);
        purchases.add(p);

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("purchaces", purchases);

        intent.putExtras(bundle);

        startActivity(intent);

    }
}
