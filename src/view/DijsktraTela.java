/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Control.criarArquivoRota;
import Model.Rota;
import java.io.File;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemadegrafos.Grafo;

/**
 *
 * @author lucas
 */
public class DijsktraTela extends javax.swing.JFrame {

    /**
     * Creates new form DijsktraTela
     */
    public DijsktraTela() {
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

        jPanel1 = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblCodOrig = new javax.swing.JLabel();
        txtCodOrig = new javax.swing.JTextField();
        lblCodDest = new javax.swing.JLabel();
        txtCodDest = new javax.swing.JTextField();
        lblKm = new javax.swing.JLabel();
        txtKm = new javax.swing.JTextField();
        lblCidadeOrig = new javax.swing.JLabel();
        txtCidadeOrig = new javax.swing.JTextField();
        lblCidadeDest = new javax.swing.JLabel();
        txtCidadeDest = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblOrigem = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnProcessar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        buttonArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBuscar.setText("Buscar:");

        lblCodOrig.setText("Código:");

        txtCodOrig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodOrigActionPerformed(evt);
            }
        });

        lblCodDest.setText("Código:");

        lblKm.setText("KM:");

        lblCidadeOrig.setText("Cidade:");

        lblCidadeDest.setText("Cidade:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblOrigem.setText("(ORIGEM)");

        lblDestino.setText("(DESTINO)");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Origem", "Cidade Origem", "Código Destino", "Cidade Destino", "Distância"
            }
        ));
        tbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl);

        btnAdicionar.setText("+");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnProcessar.setText("Processar");
        btnProcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        buttonArquivo.setText("Escolher Arquivo");
        buttonArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblKm)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblCodDest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCodOrig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodOrig, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCidadeOrig))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodDest, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCidadeDest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCidadeOrig, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(txtCidadeDest))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrigem)
                                    .addComponent(lblDestino))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(buttonArquivo)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcessar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(buttonArquivo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodOrig)
                    .addComponent(txtCodOrig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidadeOrig)
                    .addComponent(txtCidadeOrig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrigem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCidadeDest)
                        .addComponent(txtCidadeDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDestino))
                    .addComponent(lblCodDest))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKm)
                            .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcessar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ArrayList<Integer> nos = new ArrayList<Integer>();
    ArrayList<String> resumoConexoes = new ArrayList<String>();
    ArrayList<String> resumoPesos = new ArrayList<String>();
    List<Integer> caminho = new ArrayList<Integer>();
    private String resul = "";
    int somaPesos =0;
    
    private String porZero(String valor) {
        if(Integer.parseInt(valor) <10) {
            valor = "0"+valor;
        }
        return valor;
    }
    
     private String porZeroMil(String valor) {
        if(Integer.parseInt(valor) <10) {
            valor = "000"+valor;
        } else if(Integer.parseInt(valor)<100) {
            valor = "00"+valor;
        } else if(Integer.parseInt(valor)< 1000) {
            valor = "0"+valor;
        }
        return valor;
    }
    
    private void btnProcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessarActionPerformed
       //assa
        int contLinhas = tbl.getRowCount();
        
        Grafo graf = new Grafo(nos.size());
        
        for(int i = 0; i < contLinhas; i++){
            int codOrigem = Integer.parseInt((String) tbl.getValueAt(i, 0));
            int codDestino = Integer.parseInt((String) tbl.getValueAt(i, 2));
            int peso = Integer.parseInt((String) tbl.getValueAt(i, 4));
            try {
                graf.criaAresta(codOrigem, codDestino, peso);
            } catch (InvalidAlgorithmParameterException ex) {
                Logger.getLogger(DijsktraTela.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        int noOrigem = Integer.parseInt(JOptionPane.showInputDialog("No Origem:"));
        int noDestino = Integer.parseInt(JOptionPane.showInputDialog("No Destino:"));
        
        
        caminho = graf.caminhoMinimo(noOrigem, noDestino); 
        
        for(int i=0; i < caminho.size(); i++){       
            resul += caminho.get(i).toString();
            if(i != caminho.size()-1){
                resul += "->";
            }
        }
       JOptionPane.showMessageDialog(null, resul, "Caminho Minimo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnProcessarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
      
        String codOrigem = txtCodOrig.getText();
        String codDest= txtCodDest.getText();
        String cidadeOrig = txtCidadeOrig.getText();
        String cidadeDest = txtCidadeDest.getText();
        String km = txtKm.getText();
        
        //Adiciona as conexos num vetor para salvar no rotas.txt
        codOrigem = porZero(codOrigem);
        codDest = porZero(codDest);
        
        resumoConexoes.add("01"+codOrigem+"="+codDest);
        resumoPesos.add("02"+codOrigem+";"+codDest+"="+porZeroMil(km));
        
        DefaultTableModel tblGrafo = (DefaultTableModel) tbl.getModel();
        Object[] dados = {codOrigem, cidadeOrig, codDest, cidadeDest, km};
                
        tblGrafo.addRow(dados);
        
        if(!nos.contains(Integer.parseInt(codOrigem))){
            nos.add(Integer.parseInt(codOrigem));
        }
        
        if(!nos.contains(Integer.parseInt(codDest))){
            nos.add(Integer.parseInt(codDest));
        }
        somaPesos += Integer.parseInt(km);
        
        
        // Existe função dentro da classe grafo para calcular caminho minimo: g.caminhoMinimo(ori, des);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtCodOrigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodOrigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodOrigActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        criarArquivoRota arqRota= new criarArquivoRota();
        Rota rota = new Rota();
        int quantidade = nos.size();
        String numNos = porZero(Integer.toString(quantidade));
        rota.setHeader("00"+ numNos + porZeroMil(Integer.toString(somaPesos)));
        rota.setResumoConexoes(resumoConexoes);
        rota.setResumoPesos(resumoPesos);
        String trailer="09"+porZero(Integer.toString(resumoConexoes.size()))+";"+porZero(Integer.toString(resumoPesos.size()))+";"+porZeroMil(Integer.toString(somaPesos));
        rota.setTrailer(trailer);   
        arqRota.criar(rota, resul);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void buttonArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArquivoActionPerformed
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();             
        }
    }//GEN-LAST:event_buttonArquivoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(DijsktraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DijsktraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DijsktraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DijsktraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DijsktraTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnProcessar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton buttonArquivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCidadeDest;
    private javax.swing.JLabel lblCidadeOrig;
    private javax.swing.JLabel lblCodDest;
    private javax.swing.JLabel lblCodOrig;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblKm;
    private javax.swing.JLabel lblOrigem;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCidadeDest;
    private javax.swing.JTextField txtCidadeOrig;
    private javax.swing.JTextField txtCodDest;
    private javax.swing.JTextField txtCodOrig;
    private javax.swing.JTextField txtKm;
    // End of variables declaration//GEN-END:variables
}
