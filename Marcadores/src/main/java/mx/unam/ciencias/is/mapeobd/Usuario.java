/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapeobd;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luka
 */
@Entity
@Table(name="usuario")
public class Usuario {
    @Id@GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "idusuario")
    private int varIdusuario;
    @Column(name = "nickname")
    private String varNickname;
    @Column(name = "correo")
    private String varCorreo;
    @Column(name = "contrasena")
    private String varContrasena;
    @Column(name = "rol")
    private String varRol;
    @OneToMany(mappedBy="varUsuarioid")
    private Set<Marcador> varMarcadores;
    

    public int getVarIdusuario() {
        return varIdusuario;
    }

    public void setVarIdusuario(int varIdusuario) {
        this.varIdusuario = varIdusuario;
    }

    public String getVarNickname() {
        return varNickname;
    }

    public void setVarNickname(String varNickname) {
        this.varNickname = varNickname;
    }

    public String getVarCorreo() {
        return varCorreo;
    }

    public void setVarCorreo(String varCorreo) {
        this.varCorreo = varCorreo;
    }

    public String getVarContrasena() {
        return varContrasena;
    }

    public void setVarContrasena(String varContrasena) {
        this.varContrasena = varContrasena;
    }

    public Set getVarMarcadores() {
        return varMarcadores;
    }

    public void setVarMarcadores(Set varMarcadores) {
        this.varMarcadores = varMarcadores;
    }

    public String getVarRol() {
        return varRol;
    }

    public void setVarRol(String varRol) {
        this.varRol = varRol;
    }
    
    public List getVarMarcadoresLista(){
        return new ArrayList<Marcador>(this.getVarMarcadores());
    }
    
    public boolean equals(Usuario u){
        return this.getVarIdusuario() == u.getVarIdusuario();
    }
}