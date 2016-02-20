package ece651.duke.invenstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class HomePage extends AppCompatActivity implements View.OnClickListener{

    Button camera, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        camera = (Button) findViewById(R.id.btnCamera);
        list = (Button) findViewById(R.id.btnList);

        camera.setOnClickListener(this);
        list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnCamera:
                //Do stuff for if camera button is clicked
                startActivity(new Intent(this, Camera.class));
                break;
            case R.id.btnList:
                startActivity(new Intent(this, ShowList.class));
                break;
        }
    }
}
