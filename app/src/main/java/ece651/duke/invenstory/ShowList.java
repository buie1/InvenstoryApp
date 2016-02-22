package ece651.duke.invenstory;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Young-hoon Kim on 2/19/2016.
 */
public class ShowList extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd, btnRefresh;
    TextView item_id;
    DBHelper mydb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        ListView list = (ListView)findViewById(R.id.list);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);


        btnRefresh = (Button) findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(this);

        // CREATE NEW DB HELPER
        //CALL DB.SHOWUPDATEDLIST()

        mydb = new DBHelper(this);
        ArrayList array_list = mydb.getAllCotacts();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);

                Intent intent = new Intent(getApplicationContext(), DetailedListView.class);

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                Intent intent = new Intent(this, DetailedListView.class);
                intent.putExtra("ID",0);
                startActivity(intent);
                break;

            case R.id.btnRefresh:
                mydb = new DBHelper(this);
                ListView list = (ListView)findViewById(R.id.list);
                ArrayList array_list = mydb.getAllCotacts();
                ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
                list.setAdapter(arrayAdapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        // TODO Auto-generated method stub
                        int id_To_Search = arg2 + 1;

                        Bundle dataBundle = new Bundle();
                        dataBundle.putInt("id", id_To_Search);

                        Intent intent = new Intent(getApplicationContext(), DetailedListView.class);

                        intent.putExtras(dataBundle);
                        startActivity(intent);
                    }
                });
                break;

        }
    }
}
