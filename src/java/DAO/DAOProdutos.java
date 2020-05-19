/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConectaBanco;
import Model.Produtos;
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
 * @author LRR_1
 */
public class DAOProdutos {
    Connection con;
    
    public List<Produtos> ListarProduto()
    {
        List<Produtos> lista = new ArrayList<>();
        con = ConectaBanco.MetodoConexao();
        String sql = "select * from produto";
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Produtos p = new Produtos();
                p.setId_produto(rs.getInt("id_produto"));
                p.setDescricao(rs.getString("descricao"));
                p.setEstoque(rs.getInt("estoque"));
                p.setPreco(rs.getInt("preco"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
