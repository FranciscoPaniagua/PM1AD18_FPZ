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
        listaUsuarios.add(new Usuario("Paco","root"));
        listaUsuarios.add(new Usuario("ElBeto","1234"));
        listaUsuarios.add(new Usuario("ElMartin","root"));
        return listaUsuarios;
    }

    public boolean usuarioExist(Usuario usuario){
       Set<Usuario> lista=getUsuarios();
        for (Usuario user :lista) {
            if (user.getUsuario().equals(usuario.getUsuario()) && user.getPassword().equals(usuario.getPassword())){
                return true;
            }
        }
        return false;
    }
}
