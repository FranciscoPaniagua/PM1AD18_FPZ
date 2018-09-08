package francisco.paniagua.loginpasedeargumentos.models;

import java.io.Serializable;

public class Usuario implements Serializable{
    private String usuario;
    private String password;
    private int edad;
    private String estadoCivil;
    private String profesion;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Usuario(String usuario, String password, int edad, String estadoCivil, String profesion) {
        this.usuario = usuario;
        this.password = password;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.profesion = profesion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
