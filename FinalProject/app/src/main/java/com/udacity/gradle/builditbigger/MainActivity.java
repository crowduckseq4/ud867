package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AsyncResponse{
    private EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask();
    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        endpointAsyncTask.delegate = this;
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

    public void tellJoke(View view) {
//        Intent intent = new Intent(this, DisplayJoke.class);
//        intent.putExtra(getResources().getString(R.string.pass_by_value), mNewJoke.randomJokes());
//        startActivity(intent);
//        new EndpointAsyncTask().execute();
        endpointAsyncTask.execute();
    }

    @Override
    public void processFinish(String output) {
        mJoke = output;
//        Toast.makeText(this, mJoke, Toast.LENGTH_LONG).show();
    }
}
