package nnk.com.cwp11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Achilles on 6/4/2017.
 */
public class CreateActivity extends AppCompatActivity
{
    EditText noc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createebook);

        noc=(EditText)findViewById(R.id.noc);
    }
    public void takeNoOfCol(View view)
    {
        String col=noc.getText().toString();
        //int colNo=Integer.parseInt(col);
        Intent intent=new Intent(CreateActivity.this,NameActivity.class);
        intent.putExtra("noc",col);
        startActivity(intent);
    }
}
