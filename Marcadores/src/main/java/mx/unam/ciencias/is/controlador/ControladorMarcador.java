/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.security.Principal;
import java.util.List;
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

/**
 *
 * @author jonathan
 */
@Controller 
public class ControladorMarcador {
    /*Injectamos el modelo del marcador */
    @Autowired
    MarcadorDAO marcador_db;
    
    @Autowired
    UsuarioDAO usuario_db;
    
    
    /**
     * Regresa la pagina principal con los marcadores de la base de datos
     * @param model 
     * @return regresa el modelo 
     */
    @RequestMapping(value="/inicio", method = RequestMethod.GET)
    public ModelAndView marcadores(ModelMap model){
        List<Marcador> mar = marcador_db.getMarcadores();
          
        model.addAttribute("marcadores", mar);
        
        return new ModelAndView("inicio",model);
    }
    
   
    /**
     * Regresa el nombre de el jsp agrega marcador
     * @return 
     */
    @RequestMapping(value="/agregaMarcador")
    public String agregaMarcador(){
        return "agregaMarcador";
    }
    
    /**
     * Guarda un nuevo marcador 
     * @param request los atributos del marcador.
     * @return 
     */
    @RequestMapping(value="/guardaMarcador", method = RequestMethod.GET)
    public String guardaMarcador(HttpServletRequest request, Principal principal){
        String u = principal.getName();
        Usuario us_inSess = usuario_db.getUsuario(u);
        Double latitud = Double.parseDouble(request.getParameter("latitud"));
        Double longitud = Double.parseDouble(request.getParameter("longitud"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        Marcador ma = marcador_db.getMarcador(latitud, longitud);
        if(ma==null){
            Marcador m  = new Marcador();
            m.setVarLatitud(latitud);
            m.setVarLongitud(longitud);
            m.setVarNombreM(nombre);
            m.setVarDescripcion(descripcion);
            m.setVarUsuarioid(us_inSess); //Aqui va el id del usuario en sesion;
            marcador_db.guardar(m);
        }
        return "redirect:/inicio";
    }
    
    /**
     * Actualiza el marcador
     * @param model
     * @param request
     * @return 
     */ 
    @RequestMapping(value="/actualizaM", method = RequestMethod.GET)
    public ModelAndView actualizaM(ModelMap model,HttpServletRequest request){
        Double latitud = Double.parseDouble(request.getParameter("latitud"));
        Double longitud = Double.parseDouble(request.getParameter("longitud"));
        Marcador m = marcador_db.getMarcador(latitud,longitud);
        model.addAttribute("marcador",m);
        return new ModelAndView("actualizaM",model);
    }
    
    
    @RequestMapping(value="/eliminaMarcador", method = RequestMethod.GET)
    public String eliminaMarcador(HttpServletRequest request,Principal principal){
        String u = principal.getName();
        Usuario us_inSess = usuario_db.getUsuario(u);
        Double latitud = Double.parseDouble(request.getParameter("latitud"));
        Double longitud = Double.parseDouble(request.getParameter("longitud"));
        Marcador ma = marcador_db.getMarcador(latitud, longitud);
        if(ma!=null)
            if(us_inSess.equals(ma.getVarUsuarioid()))
                marcador_db.eliminar(ma);
        
        return "redirect:/inicio";  
    }
    
    @RequestMapping(value= "/actualizar", method = RequestMethod.POST)
    public String actualizar(HttpServletRequest request,Principal principal){
        if(request.getParameter("id") != null){
            String u = principal.getName();
            Usuario us_inSess = usuario_db.getUsuario(u);
            Marcador ma = marcador_db.getMarcadorId(Integer.parseInt(request.getParameter("id")));
            if(ma!=null){
                if(us_inSess.equals(ma.getVarUsuarioid())){
                    if(request.getParameter("latitud") != null && !request.getParameter("latitud").equals(""))
                        ma.setVarLatitud(Double.parseDouble(request.getParameter("latitud")));
                    if(request.getParameter("longitud") != null && !request.getParameter("longitud").equals(""))
                        ma.setVarLongitud(Double.parseDouble(request.getParameter("longitud")));
                    if(request.getParameter("nombre") != null && !request.getParameter("nombre").equals(""))
                        ma.setVarNombreM(request.getParameter("nombre"));
                    if(request.getParameter("descripcion") != null && !request.getParameter("descripcion").equals(""))
                        ma.setVarDescripcion(request.getParameter("descripcion"));
                    marcador_db.actualizar(ma);
                }
            }
        }
        return "redirect:/inicio";  
    }
}
