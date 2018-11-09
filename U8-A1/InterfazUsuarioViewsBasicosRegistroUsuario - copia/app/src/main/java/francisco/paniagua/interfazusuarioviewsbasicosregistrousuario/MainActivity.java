package francisco.paniagua.interfazusuarioviewsbasicosregistrousuario;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import javax.xml.transform.OutputKeys;

public class MainActivity extends AppCompatActivity {

    public static TextView txtHoraNacimiento, txtFechaNacimiento;
    public TextView txtUserName, txtPassword, txtNombrePila;
    public CheckBox chkJava, chkDotNet, chkPhyton;
    public RadioButton rdbMasculino, rdbFemenino;
    public Switch swNotificaciones;
    public ToggleButton tbPublicidad;
    public Spinner spOrigen;
    public static Usuario objUsr = new Usuario();
    public ImageButton btnHoraNacimiento,btnFechaNacimiento;
    public Button btnGuardar;
    public static int year, month, date, hrs, min;
    public static boolean guardarUsuario=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserName = (EditText) findViewById(R.id.et_username);
        txtPassword = (EditText) findViewById(R.id.et_password);
        txtNombrePila = (EditText) findViewById(R.id.et_nombrePila);
        chkDotNet = (CheckBox) findViewById(R.id.cb_dotnet);
        chkJava = (CheckBox) findViewById(R.id.cb_java);
        chkPhyton = (CheckBox) findViewById(R.id.cb_phyton);
        rdbFemenino = (RadioButton) findViewById(R.id.rd_femenino);
        rdbMasculino = (RadioButton) findViewById(R.id.rd_masculino);
        swNotificaciones = (Switch) findViewById(R.id.sw_notificaciones);
        tbPublicidad = (ToggleButton) findViewById(R.id.tg_publicidad);
        spOrigen = (Spinner) findViewById(R.id.sp_origen);

        btnHoraNacimiento =
                (ImageButton)findViewById(R.id.ib_horaFechaNacimiento);
        btnFechaNacimiento =
                (ImageButton)findViewById(R.id.ib_calenFechaNacimiento);

        txtHoraNacimiento =
                (TextView) findViewById(R.id.tv_horaNacimiento);
        txtFechaNacimiento =
                (TextView) findViewById(R.id.tv_fechaNacimiento);

        btnGuardar =
                (Button) findViewById(R.id.btn_guardar);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Bajar todos los valores de los GUI Widgets a un pojo
                ConfirmarDialog confirmar=new ConfirmarDialog();
                confirmar.show(getFragmentManager(),"Confirmar");

                if(guardarUsuario){

                    objUsr.setUsername(txtUserName.getText().toString());
                    objUsr.setPassword(txtPassword.getText().toString());
                    objUsr.setNombrePila(txtNombrePila.getText().toString());

                    String tecnologias = "";
                    tecnologias += (chkDotNet.isChecked())? ".NET;" : "";
                    tecnologias += (chkJava.isChecked())? "JAVA;" : "";
                    tecnologias += (chkPhyton.isChecked())? "PHYTON;":"";
                    objUsr.setTecnologias(tecnologias );

                    objUsr.setGenero((rdbFemenino.isChecked())?"FEMENINO":"MASCULINO");
                    objUsr.setNotificaciones(swNotificaciones.isChecked());
                    objUsr.setPublicidad(tbPublicidad.isChecked());
                    objUsr.setIes_origen(spOrigen.getSelectedItem().toString() );
                    objUsr.setFechaHoraNacimiento(new Date(year, month, date, hrs, min));


                    String FILENAME="Usuario_file";
                    String datos=objUsr.toString();
                    try {
                        FileOutputStream fos=openFileOutput(FILENAME,Context.MODE_PRIVATE);
                        OutputStreamWriter writer= new OutputStreamWriter(fos);
                        //BufferedWriter bw=new BufferedWriter(writer);
                        PrintWriter pw=new PrintWriter(writer);
                        // fos.write(datos.getBytes());
                        //bw.write(datos+"\n");
                        pw.println(datos);
                        writer.close();
                        fos.close();
                    } catch (FileNotFoundException e) {
                        Toast.makeText(MainActivity.this, "Error al escribir", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error al escribir", Toast.LENGTH_SHORT).show();
                    }

                    try{
                        FileInputStream fis=openFileInput(FILENAME);
                        InputStreamReader reader=new InputStreamReader(fis);
                        BufferedReader br=new BufferedReader(reader);
                        String datosFile=br.readLine();
                        br.close();
                        fis.close();
                        Toast.makeText(MainActivity.this,"Datos: "+ datosFile, Toast.LENGTH_SHORT).show();
                    }catch(Exception ex){
                        Toast.makeText(MainActivity.this, "Error al abrir el archivo", Toast.LENGTH_SHORT).show();


                    }
                    //Guardar en un archivo.

                    Toast.makeText(MainActivity.this, "Se guardó el usuario: "
                            + objUsr.toString(), Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this, "Negado", Toast.LENGTH_LONG).show();
                }

            }
        });


        btnHoraNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
            }
        });
        btnFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });

    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            //Programar nuestro código en respuesta a que se seleccionó hora
            hrs = hourOfDay;
            min = minute;
            txtHoraNacimiento.setText("Hora:" + hourOfDay + " Minuto:" + minute);
        }
    }


    public static void guardar(){

    }

    public static class ConfirmarDialog extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("¿Desea guardar el usuario?")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            guardarUsuario=true;
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            guardarUsuario=false;
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);

        }

        public void onDateSet(DatePicker view, int y, int m, int d) {
            // Do something with the date chosen by the user
            year = y;
            month = m+1;
            date = d;
            txtFechaNacimiento.setText("D:" + date +
                    " M:" + month +
                    " A:" + year);

        }
    }

}