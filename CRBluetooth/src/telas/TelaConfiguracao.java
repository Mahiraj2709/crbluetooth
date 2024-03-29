package telas;

import controle.ConfiguracaoCtrl;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import principal.CRBluetoothServer;
import utils.Constantes;

public class TelaConfiguracao extends javax.swing.JFrame {

    private static TelaConfiguracao instancia = null;

    public static TelaConfiguracao getInstance() {
        if (instancia == null) {
            instancia = new TelaConfiguracao();
        }
        instancia.inicializar();
        return instancia;
    }

    public void inicializar() {
        comboA.setSelectedIndex(CRBluetoothServer.indiceA);
        comboB.setSelectedIndex(CRBluetoothServer.indiceB);
        comboC.setSelectedIndex(CRBluetoothServer.indiceC);
        comboD.setSelectedIndex(CRBluetoothServer.indiceD);
        comboMouse.setSelectedIndex(CRBluetoothServer.indiceMouse);
    }

    /** Creates new form TelaConfiguracao */
    private TelaConfiguracao() {
        initComponents();
        setTitle("Configurações");
        comboA.removeAllItems();
        comboB.removeAllItems();
        comboC.removeAllItems();
        comboD.removeAllItems();
        comboMouse.removeAllItems();

        for (String texto : Constantes.botoes) {
            comboA.addItem(texto);
            comboB.addItem(texto);
            comboC.addItem(texto);
            comboD.addItem(texto);
        }

        for (int i = 48; i <= 57; i++) {
            comboA.addItem((char) i);
            comboB.addItem((char) i);
            comboC.addItem((char) i);
            comboD.addItem((char) i);
        }

        for (int i = 65; i <= 90; i++) {
            comboA.addItem((char) i);
            comboB.addItem((char) i);
            comboC.addItem((char) i);
            comboD.addItem((char) i);
        }

        for (int i = 1; i <= 10; i++) {
            comboMouse.addItem(i);
        }

        URL imageURL = getClass().getClassLoader().getResource("recursos/iconepadrao.png");
        Image image = Toolkit.getDefaultToolkit().createImage(imageURL);

        this.setIconImage(image);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboA = new javax.swing.JComboBox();
        comboB = new javax.swing.JComboBox();
        comboC = new javax.swing.JComboBox();
        comboD = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        comboMouse = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        butCancelar = new javax.swing.JButton();
        butSalvar = new javax.swing.JButton();

        setResizable(false);

        jLabel1.setText("Botão A:");

        jLabel2.setText("Botão B:");

        jLabel3.setText("Botão C:");

        jLabel4.setText("Botão D:");

        comboA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Velocidade do Mouse:");

        comboMouse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        butCancelar.setText("Cancelar");
        butCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelarActionPerformed(evt);
            }
        });

        butSalvar.setText("Salvar");
        butSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboA, 0, 116, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboB, 0, 117, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboC, 0, 116, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboD, 0, 116, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMouse, 0, 60, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboMouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butCancelar)
                    .addComponent(butSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void butSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSalvarActionPerformed
        // TODO add your handling code here:

        ConfiguracaoCtrl conf = new ConfiguracaoCtrl();
        conf.salvarConfiguracao(comboA.getSelectedIndex(), comboB.getSelectedIndex(),
                comboC.getSelectedIndex(), comboD.getSelectedIndex(), comboMouse.getSelectedIndex());
        this.setVisible(false);
        
    }//GEN-LAST:event_butSalvarActionPerformed

    private void butCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelarActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        
    }//GEN-LAST:event_butCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaConfiguracao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCancelar;
    private javax.swing.JButton butSalvar;
    private javax.swing.JComboBox comboA;
    private javax.swing.JComboBox comboB;
    private javax.swing.JComboBox comboC;
    private javax.swing.JComboBox comboD;
    private javax.swing.JComboBox comboMouse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
