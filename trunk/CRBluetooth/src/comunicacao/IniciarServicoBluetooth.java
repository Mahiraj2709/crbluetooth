package comunicacao;

import controle.ServidorCtrl;
import java.io.IOException;
import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnectionNotifier;
import principal.CRBluetoothServer;
import telas.SysTrayIcone;
import utils.Constantes;

public class IniciarServicoBluetooth implements Runnable {

    ServidorCtrl servidorCtrl = new ServidorCtrl();
    
    private final String serviceUUID = Constantes.SERVICE_UUID;
    private final String serviceName = Constantes.NOME_PROGRAMA;

    public IniciarServicoBluetooth() {
    }

    public void run() {
        try {


            LocalDevice.getLocalDevice().setDiscoverable(DiscoveryAgent.GIAC);

            String connectionString = "btspp://localhost:" + serviceUUID + ";name=" + serviceName;

            CRBluetoothServer.servico = (StreamConnectionNotifier) Connector.open(connectionString);
            
            while (true) {
                
                CRBluetoothServer.conexao = CRBluetoothServer.servico.acceptAndOpen();
                
                servidorCtrl.clienteConectado();
                
            }       

        } catch (BluetoothStateException ex) {
            SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, 
                    "Erro ao iniciar Serviço Bluetooth", SysTrayIcone.MSG_ERRO);
        } catch (IOException ex) {
            SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, 
                    "Erro ao iniciar Serviço Bluetooth", SysTrayIcone.MSG_ERRO);
        }
    
    }
}

