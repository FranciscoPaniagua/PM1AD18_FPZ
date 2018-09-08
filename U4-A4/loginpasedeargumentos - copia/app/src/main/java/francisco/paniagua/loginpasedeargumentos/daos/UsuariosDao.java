package francisco.paniagua.loginpasedeargumentos.daos;

import java.util.HashSet;
import java.util.Set;

import francisco.paniagua.loginpasedeargumentos.models.Usuario;

public class UsuariosDao {
    Set<Usuario> listaUsuarios;

    public UsuariosDao(){
        listaUsuarios=new HashSet<>();
    }

    public Set<Usuario> getUsuarios(){
        listaUsuarios.add(new Usuario("Paco","root",21,"Soltero","Taquero"));
        listaUsuarios.add(new Usuario("ElBeto","1234",21,"Soltero","Cocinero"));
        listaUsuarios.add(new Usuario("ElMartin","root",21,"Soltero","Lechero"));
        return listaUsuarios;
    }

    public Usuario usuarioExist(String usuario, String password){
       Set<Usuario> lista=getUsuarios();
       Usuario existe;
        for (Usuario user :lista) {
            if (user.getUsuario().equals(usuario) && user.getPassword().equals(password)){
                existe=user;
                return existe;
            }
        }
        return null;
    }
}
