package francisco.paniagua.interfazusuarioflexibleconfragments;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MensualFragment.OnSemanaCambiada{
    InicioFragment fragmentInicio;
    SemanalFragment fragmentSemana;
    MensualFragment fragmentMensual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentInicio=new InicioFragment();
        fragmentSemana=new SemanalFragment();
        fragmentMensual=new MensualFragment();
        BottomNavigationView toolbarprincipal = findViewById(R.id.toolbarPrincipal);
        ListView menuPrincipalListView=findViewById(R.id.menuListViewPrincipal);
        if(toolbarprincipal!=null){
            toolbarprincipal.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.actionInicio:
                                    getSupportFragmentManager().beginTransaction().
                                            replace(R.id.contenedorPrincipal,fragmentInicio).
                                            addToBackStack(null).
                                            commit();
                                    break;
                                case R.id.actionMensual:
                                    getSupportFragmentManager().beginTransaction().
                                            replace(R.id.contenedorPrincipal,fragmentMensual).
                                            addToBackStack(null).
                                            commit();
                                    break;
                                case R.id.actionSemanal:
                                    getSupportFragmentManager().beginTransaction().
                                            replace(R.id.contenedorPrincipal,fragmentSemana).
                                            addToBackStack(null).
                                            commit();
                                    break;
                            }
                            return true;
                        }

                    }
            );
        }else{
            menuPrincipalListView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            switch (position){
                                case 0:
                                    getSupportFragmentManager().beginTransaction().
                                            replace(R.id.contenedorPrincipal,fragmentInicio).
                                            addToBackStack(null).
                                            commit();
                                    break;
                                case 1:
                                    getSupportFragmentManager().beginTransaction().
                                            replace(R.id.contenedorPrincipal,fragmentMensual).
                                            addToBackStack(null).
                                            commit();
                                    break;
                                case 2:
                                    getSupportFragmentManager().beginTransaction().
                                            replace(R.id.contenedorPrincipal,fragmentSemana).
                                            addToBackStack(null).
                                            commit();
                                    break;
                            }

                        }
                    }
            );
        }

    }


    @Override
    public void SemanaCambiado(String nombreSemana) {
        String datosAPasar="";
        //Cuando el fragmento mensual cambie de semana
        switch(nombreSemana){
            case "Sem1":
                datosAPasar="{sem:Semana1,l:300,m:200,mi:100,j:500,v:5}";
                break;
            case "Sem2":
                datosAPasar="{sem:Semana2,l:300,m:200,mi:100,j:500,v:5}";
                break;
            case "Sem3":
                datosAPasar="{sem:Semana3,l:300,m:200,mi:100,j:500,v:5}";
                break;
            case "Sem4":
                datosAPasar="{sem:Semana4,l:300,m:200,mi:100,j:500,v:5}";
                break;
        }

        Bundle bundleDatos=new Bundle();
        bundleDatos.putString("datos",datosAPasar);
        fragmentSemana.setArguments(bundleDatos);


        getSupportFragmentManager().beginTransaction().
                replace(R.id.contenedorPrincipal,fragmentSemana).
                addToBackStack(null).
                commit();



    }
}
