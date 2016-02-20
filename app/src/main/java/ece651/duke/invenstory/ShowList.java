package ece651.duke.invenstory;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

    Button btnAdd, btnGetAll;
    TextView item_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        ListView list = (ListView)findViewById(R.id.list);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                Intent intent = new Intent(this, DetailedListView.class);
                intent.putExtra("item_Id",0);
                startActivity(intent);
                break;

            case R.id.btnGetAll:
                Toast.makeText(this,"LIST FUNCTION CURRENTLY UNAVAILABLE",Toast.LENGTH_SHORT).show();

                /* WORK IN PROGRESS!!!!!!!!!!!!!!!
                CollectionFunction repo = new CollectionFunction(this);

                ArrayList<HashMap<String, String>> itemList =  repo.getItemList();
                if(itemList.size()!=0) {
                    ListView lv = (ListView)findViewById(R.id.list);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            item_id = (TextView) view.findViewById(R.id.item_Id);
                            String itemID = item_id.getText().toString();
                            Intent objIndent = new Intent(getApplicationContext(), DetailedListView.class);
                            objIndent.putExtra("Item Number", Integer.parseInt(itemID));
                            startActivity(objIndent);
                        }
                    });
                    ListAdapter adapter = new SimpleAdapter( this,itemList, R.layout.view_item, new String[] { "id","Title"}, new int[] {R.id.item_Id, R.id.item_name});
                    lv.setAdapter(adapter);
                }else{
                    Toast.makeText(this, "No Item!", Toast.LENGTH_SHORT).show();
                }
                */
                break;

        }
    }
}
