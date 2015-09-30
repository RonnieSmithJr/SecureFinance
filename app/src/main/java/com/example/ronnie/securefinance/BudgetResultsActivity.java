package com.example.ronnie.securefinance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class BudgetResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_results);
        accessStrings();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_budget_results, menu);
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

    public void accessStrings(){
        Bundle bundle = getIntent().getExtras();

        String budget = bundle.getString("budget");
        String bills = bundle.getString("bills");
        String savings = bundle.getString("savings");
        String rent = bundle.getString("rent");


        TextView budgetTextView = (TextView) findViewById(R.id.budgetTextView);
        budgetTextView.setText("Your budget amount is: " + budget);

        TextView billsTextView = (TextView) findViewById(R.id.billsTextView);
        billsTextView.setText("Your bills amount is: " + bills);

        TextView savingsTextView = (TextView) findViewById(R.id.savingsTextView);
        savingsTextView.setText("Your savings amount is: " + savings);


        TextView rentTextView = (TextView) findViewById(R.id.rentTextView);
        rentTextView.setText("Your rent amount is: " + rent);
    }
}
