package nnk.com.cwp11;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Achilles on 6/4/2017.
 */
public class NameActivity extends AppCompatActivity
{
    TextView ex;
    public int n;
    private ListView listView;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_layout);

        //ex=(TextView)findViewById(R.id.ex);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String col=bundle.getString("noc");
        n=Integer.parseInt(col);
        listView=(ListView)findViewById(R.id.entries);
        listView.setItemsCanFocus(true);
        myAdapter=new MyAdapter(NameActivity.this,n);
        listView.setAdapter(myAdapter);


    }
}
class MyAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    public ArrayList myItems = new ArrayList();

    public MyAdapter(Context context,int nor) {
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < nor; i++) {
            ListItem listItem = new ListItem();
            listItem.caption = "Caption" + i;
            myItems.add(listItem);
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return myItems.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item, null);
            holder.caption = (EditText) convertView
                    .findViewById(R.id.etentries);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //Fill EditText with the value you have in data source
        ListItem ls=(ListItem)myItems.get(position);
        holder.caption.setText(ls.caption);
        holder.caption.setId(position);


        //we need to update adapter once we finish with editing
        holder.caption.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    final int position = v.getId();
                    final EditText Caption = (EditText) v;
                    ListItem l=(ListItem)myItems.get(position);
                    l.caption= Caption.getText().toString();
                }
            }
        });

        return convertView;
    }
}

class ViewHolder {
    EditText caption;
}

class ListItem {
    String caption;
}

