package rs.webnet.floatingactionbutton;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);

        fab.setDimmedBackgroundColor("#ddFFFFFF");
        fab.setIconOpened(R.drawable.ic_fab_opened);
        fab.setIconClosed(R.drawable.ic_fab_closed);
        fab.setButtonBackground(R.drawable.ic_fab_bgd_opened);
        fab.setRotationAngle(450);

        fab.setAnimationSpeed(300);


        _setupFabContent(fab);
    }




    private void _setupFabContent(FloatingActionButton fab) {
        for(int i=0;i<5;i++) {
            LayoutInflater inflater = getLayoutInflater();
            View item = inflater.inflate(R.layout.item,null);
            TextView textView = (TextView) item.findViewById(R.id.name);
            textView.setText("Call User "+i);
            fab.addItem(item);
        }

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher);
        fab.addItem(imageView);
    }

}
