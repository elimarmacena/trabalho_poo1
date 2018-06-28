/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.OperacoesGet;
import crud.Utilitarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Acidente;
import model.OcorrenciaAcidente;
import model.Veiculo;
import controller.OperacoesGet;
import controller.OperacoesPut;
import java.awt.event.WindowEvent;
import model.Condutor;

/**
 *
 * @author elmr
 */
public class JanelaCadAcidente extends javax.swing.JFrame {
    Acidente acidenteCadastro = null;
    ArrayList<OcorrenciaAcidente> ocorrencias = new ArrayList<>();
    JanelaNotificacoesAc notificacoesAc = null;
    JanelaDadosRotina dadosRotina = null;
    /**
     * Creates new form JanelaCadAcidente
     */
    public JanelaCadAcidente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        painelInfoAc = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFieldPessoasEnv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFieldLatitude = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFieldLongitude = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFieldDataAc = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jFieldHoraAc = new javax.swing.JFormattedTextField();
        adicionarAcidente = new javax.swing.JButton();
        jFieldDescricao = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jFieldPlaca = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jFieldVelocidade = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jFieldCnhCond = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboTitular = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        finalizarCadastro = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuPendencia = new javax.swing.JMenuItem();
        menuVeiculo = new javax.swing.JMenu();
        menuDados = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro Acidentes");

        painelInfoAc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informacoes Acidente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel2.setText("Pessoas Envolvidas");

        jFieldPessoasEnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldPessoasEnvActionPerformed(evt);
            }
        });

        jLabel3.setText("Latitude");

        jLabel4.setText("Longitude");
        jLabel4.setToolTipText("");

        jLabel5.setText("Descricao");

        jLabel6.setText("Data Acidente");

        try {
            jFieldDataAc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFieldDataAc.setText("__/__/____");

        jLabel7.setText("Horario Acidente");

        try {
            jFieldHoraAc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        adicionarAcidente.setText("ADICIONAR ACIDENTE");
        adicionarAcidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarAcidenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelInfoAcLayout = new javax.swing.GroupLayout(painelInfoAc);
        painelInfoAc.setLayout(painelInfoAcLayout);
        painelInfoAcLayout.setHorizontalGroup(
            painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInfoAcLayout.createSequentialGroup()
                .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelInfoAcLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFieldPessoasEnv)
                            .addComponent(jFieldDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFieldLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)))
                        .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelInfoAcLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFieldLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelInfoAcLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jFieldDataAc, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jFieldHoraAc)))))
                    .addGroup(painelInfoAcLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(adicionarAcidente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelInfoAcLayout.setVerticalGroup(
            painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInfoAcLayout.createSequentialGroup()
                .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFieldPessoasEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jFieldLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jFieldLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelInfoAcLayout.createSequentialGroup()
                        .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jFieldDataAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(painelInfoAcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jFieldHoraAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(adicionarAcidente))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Veiculos Envolvidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel8.setText("Placa Veiculo");

        try {
            jFieldPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFieldPlaca.setText("___-____");
        jFieldPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldPlacaActionPerformed(evt);
            }
        });

        jLabel9.setText("Velocidade Veiculo");

        jFieldVelocidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFieldVelocidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldVelocidadeActionPerformed(evt);
            }
        });

        jLabel10.setText("CNH Condutor");

        jFieldCnhCond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldCnhCondActionPerformed(evt);
            }
        });

        jLabel11.setText("Condutor Titular");

        jComboTitular.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NAO" }));

        jButton1.setText("ADICIONAR PARTICIPANTES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(39, 39, 39)
                        .addComponent(jFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jFieldVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFieldCnhCond, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jButton1)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jFieldCnhCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jFieldVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jComboTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        finalizarCadastro.setText("CADASTRAR");
        finalizarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarCadastroActionPerformed(evt);
            }
        });

        jMenu1.setText("Notificacoes");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuPendencia.setText("exibir tela de notificao");
        menuPendencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPendenciaActionPerformed(evt);
            }
        });
        jMenu1.add(menuPendencia);

        jMenuBar1.add(jMenu1);

        menuVeiculo.setText("Veiculos");
        menuVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVeiculoActionPerformed(evt);
            }
        });

        menuDados.setText("Dados Rotina");
        menuDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDadosActionPerformed(evt);
            }
        });
        menuVeiculo.add(menuDados);

        jMenuBar1.add(menuVeiculo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(painelInfoAc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(finalizarCadastro)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(painelInfoAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(finalizarCadastro)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFieldPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldPlacaActionPerformed

    private void jFieldVelocidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldVelocidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldVelocidadeActionPerformed

    private void jFieldCnhCondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldCnhCondActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldCnhCondActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void menuPendenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPendenciaActionPerformed
        notificacoesAc = new JanelaNotificacoesAc();
        notificacoesAc.setDefaultCloseOperation(HIDE_ON_CLOSE);
        notificacoesAc.setVisible(true);
    }//GEN-LAST:event_menuPendenciaActionPerformed

    private void adicionarAcidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarAcidenteActionPerformed
        int pessoasEnvovidas = Integer.parseInt( jFieldPessoasEnv.getText() );
        double latitude = Double.parseDouble( jFieldLatitude.getText() );
        double longitude = Double.parseDouble( jFieldLongitude.getText() );
        String descricao = jFieldDescricao.getText();
        String data = jFieldDataAc.getText();
        String hora = jFieldHoraAc.getText();
        String dataHora= data+" "+hora;
        acidenteCadastro = new Acidente();
        acidenteCadastro.setPessoasEnvolvidas(pessoasEnvovidas);
        acidenteCadastro.setLatitude(latitude);
        acidenteCadastro.setLongitude(longitude);
        acidenteCadastro.setDescricao(descricao);
        acidenteCadastro.setData(Utilitarios.strDateBrToDate(dataHora));
    }//GEN-LAST:event_adicionarAcidenteActionPerformed

    private void jFieldPessoasEnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldPessoasEnvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldPessoasEnvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String placa = jFieldPlaca.getText();
        int velocidadeV = Integer.parseInt(jFieldVelocidade.getText());
        Veiculo veiculo = OperacoesGet.getVeiculo(placa);
        Condutor condutor = OperacoesGet.getContudor(jFieldCnhCond.getText());
        String resultEscolha = jComboTitular.getSelectedItem().toString();
        boolean titular = resultEscolha.equals("SIM");
        OcorrenciaAcidente ocorrencia = new OcorrenciaAcidente();
        ocorrencia.setCondutor(condutor);
        ocorrencia.setVeiculo(veiculo);
        ocorrencia.setCondutor_titular(titular);
        ocorrencia.setVelocidade(velocidadeV);
        ocorrencias.add(ocorrencia);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void finalizarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarCadastroActionPerformed
        if (ocorrencias.size() == 0){
            JOptionPane.showMessageDialog(null, "ADICIONAR VEICULOS QUE PARTICIPARAM DO ACIDENTE");
        }
        else{
            acidenteCadastro.setVeiculosEnvolvidos(ocorrencias);
            OperacoesPut.salvarAcidente(acidenteCadastro);
            JOptionPane.showMessageDialog(null, "CADASTRO EFETUADO");
            //modularizar
            jFieldPessoasEnv.setText("");
            jFieldLatitude.setText("");
            jFieldLongitude.setText("");
            jFieldDescricao.setText("");
            jFieldDataAc.setValue(null);
            jFieldHoraAc.setValue(null);
            jFieldPlaca.setValue(null);
            jFieldVelocidade.setText("");
            jFieldCnhCond.setText("");
            
            //this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        
    }//GEN-LAST:event_finalizarCadastroActionPerformed

    private void menuDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDadosActionPerformed
        dadosRotina = new JanelaDadosRotina();
        dadosRotina.setDefaultCloseOperation(HIDE_ON_CLOSE);
        dadosRotina.setVisible(true);
    }//GEN-LAST:event_menuDadosActionPerformed

    private void menuVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVeiculoActionPerformed
        
    }//GEN-LAST:event_menuVeiculoActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaCadAcidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadAcidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadAcidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadAcidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadAcidente().setVisible(true);
            }
        });
    }
	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarAcidente;
    private javax.swing.JButton finalizarCadastro;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboTitular;
    private javax.swing.JTextField jFieldCnhCond;
    private javax.swing.JFormattedTextField jFieldDataAc;
    private javax.swing.JTextField jFieldDescricao;
    private javax.swing.JFormattedTextField jFieldHoraAc;
    private javax.swing.JTextField jFieldLatitude;
    private javax.swing.JTextField jFieldLongitude;
    private javax.swing.JTextField jFieldPessoasEnv;
    private javax.swing.JFormattedTextField jFieldPlaca;
    private javax.swing.JFormattedTextField jFieldVelocidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuDados;
    private javax.swing.JMenuItem menuPendencia;
    private javax.swing.JMenu menuVeiculo;
    private javax.swing.JPanel painelInfoAc;
    // End of variables declaration//GEN-END:variables
}
