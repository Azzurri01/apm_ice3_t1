package com.example.activitiespassingmessage;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private EditText MessageEditText;
    private TextView resultTextView;
    private TextView confirmation;
    public String message;
    public static final String EXTRA_TEXT = "com.example.activitiespassingmessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        message = intent.getStringExtra(LastActivity.EXTRA_TEXT);
        confirmation = (TextView) findViewById(R.id.resultTextView);
        confirmation.setText(message);

        //Dimitri Johannes code
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Cast text objects
                MessageEditText = (EditText) findViewById(R.id.MessageEditText);
                resultTextView = (TextView) findViewById(R.id.resultTextView);
                message = MessageEditText.getText() + ".";


                //Get text results and display in userTextView
                if(!(MessageEditText.getText().toString().isEmpty()))
                {

                    //resultTextView.setText(message);

                    //Open Activity2
                    Activity2();
                }

                else
                {
                    //Report error
                    resultTextView.setText("Error: No message entered!!!");
                }

                //Set text fields to null
                //MessageEditText.setText("");
            }
        });
    }

    public void Activity2()
    {
        //Capture text and store in string
        String textBox = MessageEditText.getText().toString();

        //Declare intent
        Intent intent = new Intent(this, Activity2.class);

        intent.putExtra(EXTRA_TEXT, textBox);

        //Start Activity2
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
