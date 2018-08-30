package francisco.paniagua.ciclodevida_layout;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView txtState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       txtState=(TextView)findViewById(R.id.txtState);
       txtState.setMovementMethod(new ScrollingMovementMethod());
        Toast.makeText(this, "On create", Toast.LENGTH_SHORT).show();
        Log.d("STATE","on create");
        txtState.setText(txtState.getText().toString()+"\n onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On resume", Toast.LENGTH_SHORT).show();
        Log.d("STATE","on start");
        txtState=(TextView)findViewById(R.id.txtState);
        txtState.setText(txtState.getText().toString()+"\n onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT).show();
        Log.d("STATE","on destroy");
        txtState=(TextView)findViewById(R.id.txtState);
        txtState.setText(txtState.getText().toString()+"\n onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
        Log.d("STATE","on resume");
        txtState=(TextView)findViewById(R.id.txtState);
        txtState.setText(txtState.getText().toString()+"\n onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "On Stop", Toast.LENGTH_SHORT).show();
        Log.d("STATE","on stop");
        txtState=(TextView)findViewById(R.id.txtState);
        txtState.setText(txtState.getText().toString()+"\n onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT).show();
        Log.d("STATE","on pause");
        txtState=(TextView)findViewById(R.id.txtState);
        txtState.setText(txtState.getText().toString()+"\n onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "On Restart", Toast.LENGTH_SHORT).show();
        Log.d("STATE","on restart");
        txtState=(TextView)findViewById(R.id.txtState);
        txtState.setText(txtState.getText().toString()+"\n onRestart");
    }
}

