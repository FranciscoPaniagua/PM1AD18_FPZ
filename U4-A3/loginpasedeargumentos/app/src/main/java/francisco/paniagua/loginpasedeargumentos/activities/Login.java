package francisco.paniagua.loginpasedeargumentos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import francisco.paniagua.loginpasedeargumentos.R;
import francisco.paniagua.loginpasedeargumentos.daos.UsuariosDao;
import francisco.paniagua.loginpasedeargumentos.models.*;
public class Login extends Activity {
    EditText usuario,password;
    Button login;
    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario= (EditText)findViewById(R.id.usuario);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        titulo=(TextView)findViewById(R.id.txtTitulo);
        titulo.setText(getIntent().getStringExtra("titulo"));
        usuario.requestFocus();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UsuariosDao dao = new UsuariosDao();
                boolean result = dao.usuarioExist(new Usuario(usuario.getText().toString(),password.getText().toString()));
                Intent respuesta=new Intent();
                respuesta.putExtra("resultado",result);
                setResult(MainActivity.LOGIN_INTENT_CODE,respuesta);
                finish();
            }
        });
    }
//Para evitar que se regrese con el botón de back
    @Override
    public void onBackPressed() {


    }
}
