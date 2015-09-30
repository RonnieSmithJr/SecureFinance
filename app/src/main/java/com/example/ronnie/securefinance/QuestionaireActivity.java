package com.example.ronnie.securefinance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class QuestionaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire);
        EditText budget = (EditText) findViewById(R.id.budget);
        budget.setText("Enter your monthly budget");

        EditText bills = (EditText) findViewById(R.id.bills);
        bills.setText("Enter your monthly bils");

        EditText rent = (EditText) findViewById(R.id.rent);
        rent.setText("Enter your monthly rent");

        EditText savings = (EditText) findViewById(R.id.savings);
        savings.setText("Enter your monthly savings goal");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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

    public void submitBudget(View view){
        Intent intent = new Intent(getApplicationContext(), BudgetResultsActivity.class);
        EditText budgetAmount = (EditText) findViewById(R.id.budget);
        String budget = budgetAmount.getText().toString();

        EditText billsAmount = (EditText) findViewById(R.id.bills);
        String bills = billsAmount.getText().toString();

        EditText savingsGoal = (EditText) findViewById(R.id.savings);
        String savings = savingsGoal.getText().toString();

        EditText rentAmount = (EditText) findViewById(R.id.rent);
        String rent = rentAmount.getText().toString();

        Bundle bundle = new Bundle();

        bundle.putString("budget", budget);
        bundle.putString("bills", bills);
        bundle.putString("savings", savings);
        bundle.putString("rent", rent);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        EditText budgetAmount = (EditText) findViewById(R.id.budget);
        String budget = budgetAmount.getText().toString();

        EditText billsAmount = (EditText) findViewById(R.id.bills);
        String bills = billsAmount.getText().toString();

        EditText savingsGoal = (EditText) findViewById(R.id.savings);
        String savings = savingsGoal.getText().toString();

        EditText rentAmount = (EditText) findViewById(R.id.rent);
        String rent = rentAmount.getText().toString();

        savedInstanceState.putString("budget", budget);
        savedInstanceState.putString("bills", bills);
        savedInstanceState.putString("savings", savings);
        savedInstanceState.putString("rent", rent);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
       savedInstanceState.getString("budget");
       savedInstanceState.getString("bills");
       savedInstanceState.getString("savings");
       savedInstanceState.getString("rent");

    }
}
