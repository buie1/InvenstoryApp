package ece651.duke.invenstory;

/**
 * Created by Young-hoon Kim on 2/19/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailedListView extends AppCompatActivity implements android.view.View.OnClickListener {

    Button btnSave, btnDelete;
    Button btnClose;
    EditText editTextTitle;
    EditText editTextAuthor;
    EditText editTextPrice;
    private int _Item_Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_list_view);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextAuthor = (EditText) findViewById(R.id.editTextAuthor);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Item_Id = 0;
        Intent intent = getIntent();
        _Item_Id = intent.getIntExtra("item_Id", 0);

        /* THIS IS BROKEN
        // SOMETHING TO DO WITH CURSOR???????

        CollectionFunction repo = new CollectionFunction(this);
        Item item = new Item();
        item = repo.getItemById(_Item_Id);


        editTextPrice.setText(String.valueOf(item.price));
        editTextTitle.setText(item.item_Title);
        editTextAuthor.setText(item.author);
        */
    }


    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnSave:
                Toast.makeText(this, "SAVE FUNCTION IS CURRENTLY BROKEN", Toast.LENGTH_SHORT).show();

                            /* CURRENT WORK IN PROGRESS
            CollectionFunction repo = new CollectionFunction(this);
            Item item = new Item();
            item.price = Integer.parseInt(editTextPrice.getText().toString());
            item.author = editTextAuthor.getText().toString();
            item.item_Title = editTextTitle.getText().toString();
            item.item_ID = _Item_Id;

            if (_Item_Id == 0) {
                _Item_Id = repo.insert(item);

                Toast.makeText(this, "Added New Item", Toast.LENGTH_SHORT).show();
            } else {

                repo.update(item);
                Toast.makeText(this, "Collection Record updated", Toast.LENGTH_SHORT).show();
            }*/
                break;
            case R.id.btnDelete:
                CollectionFunction repo = new CollectionFunction(this);
                repo.delete(_Item_Id);
                Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT);
                finish();
                break;
            case R.id.btnClose:
                finish();
                break;
        }
    }
}
