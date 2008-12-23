package comunicacao;

import controle.ServicoCtrl;
import controle.ServidorCtrl;
import java.io.DataInputStream;
import java.io.IOException;
import principal.CRBluetoothServer;
import utils.Constantes;

public class ConexaoBluetooth implements Runnable {

    ServidorCtrl servidorCtrl = new ServidorCtrl();
    ServicoCtrl servicoCtrl = new ServicoCtrl();

    public ConexaoBluetooth() {
    }

    public void run() {
        try {

            CRBluetoothServer.entrada = CRBluetoothServer.conexao.openDataInputStream();
            CRBluetoothServer.saida = CRBluetoothServer.conexao.openDataOutputStream();

            String lido = CRBluetoothServer.entrada.readUTF();
            
            System.out.println("lido: " + lido);

            while (!lido.equals(Constantes.STR_FECHA_CONEXAO)){
                
                servicoCtrl.avaliar(lido);

                lido = CRBluetoothServer.entrada.readUTF();
                
                System.out.println("lido: " + lido);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {            
            servidorCtrl.clienteDesconectado();            
        }

    }
}

