package francisco.paniagua.loginpasedeargumentos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import francisco.paniagua.loginpasedeargumentos.R;
import francisco.paniagua.loginpasedeargumentos.models.Usuario;

public class MainActivity extends Activity {
public static final int  LOGIN_INTENT_CODE=15;
public static final int  ALUMNOS_INTENT_CODE=25;
TextView contenidoUsuario,contenidoEdad,contenidoEstadoCivil,contenidoProfesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contenidoUsuario=(TextView)findViewById(R.id.contenidoUsuario);
        contenidoEdad=(TextView)findViewById(R.id.contenidoEdad);
        contenidoEstadoCivil=(TextView)findViewById(R.id.contenidoEstadoCivil);
        contenidoProfesion=(TextView)findViewById(R.id.contenidoProfesion);
        Intent  loginIntent =new Intent(MainActivity.this,Login.class);
        loginIntent.putExtra("titulo","Bienvenido autentícate");
        startActivityForResult(loginIntent,LOGIN_INTENT_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==LOGIN_INTENT_CODE){
            boolean res= data.getBooleanExtra("resultado",false);
            Usuario usuario;
            if (res){
                Toast.makeText(this,"Bienvenido Usuario",Toast.LENGTH_LONG).show();
                usuario=(Usuario) data.getSerializableExtra("usuario");
                contenidoUsuario.setText(usuario.getUsuario().toString());
                contenidoEdad.setText(String.valueOf(usuario.getEdad()));
                contenidoEstadoCivil.setText(usuario.getEstadoCivil().toString());
                contenidoProfesion.setText(usuario.getProfesion().toString());
            }else{
                Toast.makeText(this," Autenticacion Fallida",Toast.LENGTH_LONG).show();
                Intent  loginIntent =new Intent(MainActivity.this,Login.class);
                startActivityForResult(loginIntent,LOGIN_INTENT_CODE);
            }
//            String nombreUsuario=data.getStringExtra("usuario");
//            String password=data.getStringExtra("password");
//            Toast.makeText(this, nombreUsuario+" "+password,Toast.LENGTH_LONG).show();
        }
    }
}
