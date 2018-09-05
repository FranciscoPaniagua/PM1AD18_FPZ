package francisco.paniagua.loginpasedeargumentos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent respuesta=new Intent();
                respuesta.putExtra("usuario",usuario.getText().toString());
                respuesta.putExtra("password",password.getText().toString());
                setResult(MainActivity.LOGIN_INTENT_CODE,respuesta);
                finish();
            }
        });
    }
}
