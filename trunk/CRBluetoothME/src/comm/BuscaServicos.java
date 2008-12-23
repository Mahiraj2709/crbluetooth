package comm;

import java.io.IOException;
import java.util.Vector;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import main.CRBluetoothME;
import view.TelaBusca;
import view.TelaPrincipal;

public class BuscaServicos implements Runnable {

    private Vector devicesDiscovered;
    static final String serverUUID = "061020070110198603091986";
    static final UUID uuid = new UUID(serverUUID, false);
    public TelaBusca tela;

    public BuscaServicos(TelaBusca tela) {
        this.tela = tela;
    }

    public void run() {
        final Object inquiryCompletedEvent = new Object();
        final Object serviceCompleteEvent = new Object();

        CRBluetoothME.devices = new Vector();
        CRBluetoothME.servicos = new Vector();

        devicesDiscovered = new Vector();

        DiscoveryListener listener = new DiscoveryListener() {

            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {                
                devicesDiscovered.addElement(btDevice);
                String device = btDevice.getBluetoothAddress();
                try {
                    device = btDevice.getFriendlyName(false);
                } catch (IOException cantGetDeviceName) {
                }
                CRBluetoothME.devices.addElement(device);
            }

            public void inquiryCompleted(int discType) {
                
                for (int i = 0; i < devicesDiscovered.size(); i++) {
                    RemoteDevice remote = (RemoteDevice) devicesDiscovered.elementAt(i);                    
                    UUID[] searchUuidSet = new UUID[]{uuid};
                    int[] attrIDs = new int[]{
                        0x0100 // Service name
                    };                    

                    try {
                        synchronized (serviceCompleteEvent) {
                            LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet, remote, this);
                            serviceCompleteEvent.wait();
                        }
                    } catch (Throwable e) {
                        CRBluetoothME.mostraMsgErro("Erro ao buscar serviço", TelaPrincipal.getInstancia());                        
                    }

                }

                synchronized (inquiryCompletedEvent) {
                    inquiryCompletedEvent.notifyAll();
                }
            }

            public void serviceSearchCompleted(int transID, int respCode) {
                synchronized (serviceCompleteEvent) {
                    serviceCompleteEvent.notifyAll();
                }
            }

            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
                if (servRecord.length > 0) {
                    String url = servRecord[0].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);                    
                    CRBluetoothME.servicos.addElement(url);
                }
            }
        };

        synchronized (inquiryCompletedEvent) {
            try {
                boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
                if (started) {
                    inquiryCompletedEvent.wait();
                }                
                tela.atualizarDispositivos();
            } catch (Throwable e) {
                CRBluetoothME.mostraMsgErro("Erro ao buscar dispositivos", TelaPrincipal.getInstancia());                
            }
        }
    }
}
