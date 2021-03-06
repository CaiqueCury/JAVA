package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author logonrm
 */
public class UsuarioDAO {

    private Connection connection;
    private PreparedStatement p;
    private ResultSet rs;
    private String sql;

    public boolean pesquisarUsuario(Usuario usuario) {
        boolean achou = false;
        sql = "select * from java_usuarios where login = ? and senha = ?";
        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, usuario.getLogin());
            p.setString(2, usuario.getSenha());
            rs = p.executeQuery();
            achou = rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return achou;
    }

}
