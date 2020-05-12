/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author LRR_1
 */
public class Usuarios {
    
    private int codusuario;
    private String login;
    private String senha;

    /**
     * @return the codusuario
     */
    public int getCodusuario() {
        return codusuario;
    }

    /**
     * @param codusuario the codusuario to set
     */
    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}