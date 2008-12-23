package principal;

import controle.ConfiguracaoCtrl;
import java.awt.Robot;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import telas.SysTrayIcone;

public class CRBluetoothServer {

    public static StreamConnectionNotifier servico = null;
    public static StreamConnection conexao = null;
    public static DataInputStream entrada = null;
    public static DataOutputStream saida = null;
    public static Robot robot = null;
    
    public static int indiceA = 0;
    public static int indiceB = 1;
    public static int indiceC = 2;
    public static int indiceD = 5;
    public static int indiceMouse = 2;

    public static void main(String args[]) {
        
        ConfiguracaoCtrl conf = new ConfiguracaoCtrl();
        conf.recuperarConfiguracao();
        
        SysTrayIcone icon = SysTrayIcone.getInstance();
        icon.mostra(true);
    }
}

