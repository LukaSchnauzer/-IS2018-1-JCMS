/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;
/*Injectamos el modelo del usuario */
import java.security.Principal;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import mx.unam.ciencias.is.mapeobd.Marcador;
import mx.unam.ciencias.is.modelo.MarcadorDAO;
import mx.unam.ciencias.is.mapeobd.Usuario;
import mx.unam.ciencias.is.modelo.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author luka
 */
@Controller
public class ControladorUsuario {
    @Autowired
    MarcadorDAO marcador_db;
    
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(contrasena);
        String contrasenaConf = request.getParameter("password-conf");
        Usuario u = usuario_db.getUsuario(correo);
        if(u==null && (contrasenaConf.equals(contrasena))){
            u = new Usuario();
            u.setVarNickname(nick);
            u.setVarCorreo(correo);
            u.setVarContrasena(hashedPassword);
            u.setVarRol("ROLE_ADMIN");
            usuario_db.guardar(u);       
        }
        return "redirect:/";
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String nuevoinicio(){
        return "login";   
    }
    
    /*
    * Verifica si los datos de login son de un usuario ya registrado
    */
    /*
    @RequestMapping(value="/verifica", method = RequestMethod.POST)
    public ModelAndView verifica(ModelMap model,HttpServletRequest request){
        String correo = request.getParameter("email");
        String contrasena = request.getParameter("password");
        Usuario u = usuario_db.getUsuario(correo);
        if(u==null || !u.getVarContrasena().equals(contrasena)){ //no esta registrado
            return new ModelAndView("login",model);
        }
        
        List<Marcador> mar = marcador_db.getMarcadores();
        model.addAttribute("marcadores", mar);
        return new ModelAndView("inicio",model);  
    }*/
    
    @RequestMapping(value="/registro", method = RequestMethod.POST)
    public String registrar(){
        return "register";   
    }
    

    @RequestMapping(value="/perfil", method = RequestMethod.GET)
    public ModelAndView perfil(HttpServletRequest request, ModelMap model, Principal principal){
        String u = principal.getName();
        Usuario us_inSess = usuario_db.getUsuario(u);
        
        List<Marcador> mar = marcador_db.getMarcadores();
        List<Marcador> mar_u = new ArrayList<Marcador>();
        
        for(Marcador m : mar){
            if(m.getVarUsuarioid().equals(us_inSess))
                mar_u.add(m);
        }
        
        model.addAttribute("correo", u);
        model.addAttribute("nombre", us_inSess.getVarNickname());
        model.addAttribute("marcadores", mar_u);
        
        return new ModelAndView("perfil",model);  
    }
}