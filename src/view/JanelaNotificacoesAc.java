/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import crud.TableFuncionario;
import crud.Utilitarios;
import crud.TableRelatorioAcidente;
import crud.Utilitarios;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.RelatorioAcidente;

/**
 *
 * @author elmr
 */
public class JanelaNotificacoesAc extends javax.swing.JFrame {
    int linhaSelecionada = 0;
    /**
     * Creates new form JanelaNotificacoesAc
     */
    public JanelaNotificacoesAc() {
        initComponents();
        this.atualizarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRelatorios = new javax.swing.JTable();
        bDeletarNotificacao = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaRelatorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "COD", "PLACA VEICULO", "CNH CONDUTOR", "NUMERO OCUPANTES", "DESCRICAO ACIDENTE", "LATITUDE", "LONGITUDE", "DATA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRelatorios.setCellSelectionEnabled(true);
        tabelaRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRelatoriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaRelatorios);
        tabelaRelatorios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        bDeletarNotificacao.setText("DELETAR NOTIFICAO");
        bDeletarNotificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletarNotificacaoActionPerformed(evt);
            }
        });

        jButton2.setText("ATUALIZAR STATUS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Notificacoes de Acidentes Pendentes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(bDeletarNotificacao)
                                .addGap(135, 135, 135)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDeletarNotificacao)
                    .addComponent(jButton2))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelaRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRelatoriosMouseClicked
        linhaSelecionada = tabelaRelatorios.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tabelaRelatoriosMouseClicked

    private void bDeletarNotificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletarNotificacaoActionPerformed
        System.out.println((String) tabelaRelatorios.getModel().getValueAt(linhaSelecionada, 0));
        this.atualizarTabela();
    }//GEN-LAST:event_bDeletarNotificacaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaNotificacoesAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaNotificacoesAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaNotificacoesAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaNotificacoesAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaNotificacoesAc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDeletarNotificacao;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaRelatorios;
    // End of variables declaration//GEN-END:variables

    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) tabelaRelatorios.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        TableRelatorioAcidente tabela = new TableRelatorioAcidente();
        List<RelatorioAcidente> relatorios;
		try {
			relatorios = tabela.relatoriosPendentes();
			for(RelatorioAcidente relatorio : relatorios) {
				model.addRow(new Object[] {
					relatorio.getCampoIdentificacao(),
					relatorio.getPlaca(),
					relatorio.getNumCnh(),
                                        relatorio.getNumOcupantes(),
                                        relatorio.getDescricao(),
                                        relatorio.getLatitude(),
                                        relatorio.getLongitude(),
                                        Utilitarios.dataToStringBR(relatorio.getData())
				});
			}
		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		}

    }
}