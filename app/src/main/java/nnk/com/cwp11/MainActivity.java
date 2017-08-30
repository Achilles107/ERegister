package nnk.com.cwp11;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createEbook(View v)
    {
        Intent intent=new Intent(MainActivity.this,CreateActivity.class);
        startActivity(intent);
    }
    public void viewEbook(View view)
    {
        Intent intent=new Intent(MainActivity.this,ViewActivity.class);
        startActivity(intent);
    }
}





