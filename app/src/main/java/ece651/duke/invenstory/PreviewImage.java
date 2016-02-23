package ece651.duke.invenstory;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by jonbuie on 2/22/16.
 */
public class PreviewImage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        if(null == savedInstanceState){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, ThumbnailGenFragment.newInstance())
                    .commit();
        }
    }

}
