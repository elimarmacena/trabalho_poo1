/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;

/**
 *
 * @author 20161bsi0314
 */
public interface OperacoesBaseDados<T> {
    void createTable() throws SQLException, ClassNotFoundException;
    void cadastar(T informacao);
    
}
