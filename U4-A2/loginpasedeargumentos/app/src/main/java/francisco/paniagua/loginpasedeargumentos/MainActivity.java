package francisco.paniagua.loginpasedeargumentos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
public static final int  LOGIN_INTENT_CODE=15;
public static final int  ALUMNOS_INTENT_CODE=25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent  loginIntent =new Intent(MainActivity.this,Login.class);
        loginIntent.putExtra("titulo","Bienvenido autentícate");
        startActivityForResult(loginIntent,LOGIN_INTENT_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==LOGIN_INTENT_CODE){
            String nombreUsuario=data.getStringExtra("usuario");
            String password=data.getStringExtra("password");
            Toast.makeText(this, nombreUsuario+" "+password,Toast.LENGTH_LONG).show();
        }
    }
}
