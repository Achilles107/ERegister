package nnk.com.cwp11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Achilles on 9/3/2017.
 */
public class BookActivity extends AppCompatActivity
{
    ArrayList<String> arrayList=new ArrayList<String>();
    TextView tv;
    String[] cols;
    //TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_layout);
        Intent intent=getIntent();
        //Bundle bundle=intent.getExtras();
        arrayList=intent.getStringArrayListExtra("col_names");
        cols=new String[arrayList.size()];
        for (int i=0;i<arrayList.size();i++)
        {
            cols[i]=arrayList.get(i);
        }
        TableLayout tb=(TableLayout)findViewById(R.id.table);

        //TextView test=new TextView(this);
        //test.setText("Hi");
        //tableRow.addView(test);
        //tb.addView(tableRow,new TableLayout.LayoutParams());
        for(int i=0;i<arrayList.size();i++)
        {
            TableRow tableRow=new TableRow(this);
            tv=new TextView(this);
            tv.setText(cols[i]);
            tv.setTextSize(30);
            tableRow.addView(tv);
            tb.addView(tableRow,new TableLayout.LayoutParams());
        }

        //test=(TextView)findViewById(R.id.test);
        //test.setText(cols[0].toString());



    }
}
