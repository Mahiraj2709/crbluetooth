/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.io.Connection;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import main.CRBluetoothME;
import util.Constantes;
import view.TelaPrincipal;

/**
 *
 * @author Elio
 */
public class ConectaServico{

    private TelaPrincipal tela;

    public ConectaServico(TelaPrincipal tela) {
        this.tela = tela;
    }

    public void conectar() {

        try {

            CRBluetoothME.streamConnection = (StreamConnection) Connector.open((String)CRBluetoothME.servicos.elementAt(CRBluetoothME.selecionado));            
            CRBluetoothME.saida = new DataOutputStream(CRBluetoothME.streamConnection.openOutputStream());
            CRBluetoothME.entrada = new DataInputStream(CRBluetoothME.streamConnection.openInputStream());

            TestaConexao testa = new TestaConexao();
            Thread t = new Thread(testa);
            t.start();
            
            tela.atualizaConectado();            

        } catch (Throwable e) {
            
            tela.addTexto(Constantes.ERRO_CONEXAO);
            tela.addTexto((String)CRBluetoothME.devices.elementAt(CRBluetoothME.selecionado));
        }
        
        CRBluetoothME.mostra(tela);
    }
}
