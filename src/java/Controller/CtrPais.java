/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexao.ConectaBanco;
import Model.Pais;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodney
 */
public class CtrPais {
    
    PreparedStatement ps;
    Connection con;
    
    public void CadastrarPais(Pais p)
    {
      
        String sql = "insert into pais (nome,sigla) values (?,?)";
        con = ConectaBanco.MetodoConexao();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getSigla());
            ps.execute();
            System.out.println("Inseriu no banco");
            //Encerrando a conexão
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CtrPais.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
    
    
    public List<Pais> Listar()
    {   
        //Criando objeto Result Set
        ResultSet rs;
        //Criando objeto do tipo lista da classe pais
        List<Pais> objLista = new ArrayList<Pais>();
        //Criando uma string para selecionar todos os dados da tabela
        String sql = "select * from pais";
        //Atribuindo conexão para a variavel con
        con = ConectaBanco.MetodoConexao();
        try {
            ps = con.prepareStatement(sql);
            //Executando a consulta
            rs= ps.executeQuery();
           
            //Laço para carregar o objeto lista com dados
            while(rs.next())
            {
                //Criando objeto individual da classe pais para
                //ser inserido no objeto lista
                Pais p = new Pais();
                p.setCodpais(rs.getInt("codpais"));
                p.setNome(rs.getString("nome"));
                p.setSigla(rs.getString("sigla"));
                //Inserindo objeto individual no objeto de lista
                objLista.add(p);
            }       
            
             con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrPais.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Retornando o objeto carregado de dados do banco
        return objLista;
    }
    
}
