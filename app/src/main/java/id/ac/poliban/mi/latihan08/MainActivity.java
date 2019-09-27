package id.ac.poliban.mi.latihan08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
/*
    Press Back Twice To Exit
*/

public class MainActivity extends AppCompatActivity {
    private boolean pressBackTwiceToExit;
    private Runnable mRunnable = ()-> pressBackTwiceToExit=false;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    public void onBackPressed() {
        if(pressBackTwiceToExit) {
            super.onBackPressed();
            return;
        }
        pressBackTwiceToExit=true;
        Toast.makeText(this, "press back again to exit", Toast.LENGTH_SHORT).show();
        mHandler.postDelayed(mRunnable, 2000);
    }
}
