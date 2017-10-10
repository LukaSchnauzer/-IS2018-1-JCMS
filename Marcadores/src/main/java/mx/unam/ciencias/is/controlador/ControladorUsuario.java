/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;
/*Injectamos el modelo del usuario */
import javax.servlet.http.HttpServletRequest;
import mx.unam.ciencias.is.mapeobd.Usuario;
import mx.unam.ciencias.is.modelo.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author luka
 */
@Controller
public class ControladorUsuario {
    @Autowired
    UsuarioDAO usuario_db;
    
    /**
     * Guarda un nuevo usuario 
     * @param request los atributos del marcador.
     * @return 
     */
    @RequestMapping(value="/guardaUsuario", method = RequestMethod.GET)
    public String guardaUsuario(HttpServletRequest request){
        String nick = request.getParameter("nick");
        String correo = request.getParameter("email");
        String contrasena = request.getParameter("password");
        String contrasenaConf = request.getParameter("password-conf");
        Usuario u = usuario_db.getUsuario(correo);
        System.out.println(nick);
        System.out.println(contrasena);
        System.out.println(contrasenaConf);
        if(u==null && (contrasenaConf.equals(contrasena))){
            u = new Usuario();
            u.setVarNickname(nick);
            u.setVarCorreo(correo);
            u.setVarContrasena(contrasena);
            usuario_db.guardar(u);       
        }
        return "redirect:/";
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String nuevoinicio(){
        return "login";   
    }
    
    @RequestMapping(value="/registro", method = RequestMethod.POST)
    public String registrar(){
        return "register";   
    }
    

    @RequestMapping(value="/perfil", method = RequestMethod.GET)
    public String perfil(){
        return "perfil";   
    }
}