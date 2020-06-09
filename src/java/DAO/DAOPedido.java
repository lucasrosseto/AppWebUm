/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConectaBanco;
import Model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LRR_1
 */
public class DAOPedido {
    
    Connection con;
    
    public void CadastrarPedido(Pedido p)
    {
        String sql = "insert into pedido (id_cliente, id_vendedor, prazo_entrega)";
        sql += "values (?,?,?)";
        con = ConectaBanco.MetodoConexao();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId_cliente());
            ps.setInt(2, p.getId_vendedor());
            ps.setString(3, p.getPrazo_entrega());
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
