package rs.webnet.floatingactionbutton;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);







        fab.setDimmedBackgroundColor("#99000000");
        fab.setIconOpened(R.drawable.ic_fab_opened);
        fab.setIconClosed(R.drawable.ic_fab_closed);
        fab.setButtonBackground(R.drawable.ic_fab_bgd_opened);
        fab.setRotationAngle(450);

        fab.setAnimationSpeed(300);








        for(int i=0;i<5;i++) {
            Button tv = new Button(this);
            tv.setPadding(10,10,10,10);
            tv.setText("Button "+i);
            fab.addItem(tv);
        }

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "klik");
            }
        });

        fab.addItem(imageView);
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
}
