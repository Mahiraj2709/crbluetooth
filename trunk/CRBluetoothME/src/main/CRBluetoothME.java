package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Vector;
import javax.microedition.io.StreamConnection;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import view.TelaPrincipal;

public class CRBluetoothME extends MIDlet {

    public static String e = null;
    
    public static StreamConnection streamConnection = null;
    public static DataOutputStream saida = null;
    public static DataInputStream entrada = null;
    
    public static MIDlet midlet;
    
    public static Vector servicos = null;
    public static Vector devices = null;
    public static int selecionado;

    public CRBluetoothME() {
        midlet = this;
    }

    public void startApp() {
        TelaPrincipal tela = TelaPrincipal.getInstancia();
        mostra(tela);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {

        try {
            if (streamConnection != null) {
                streamConnection.close();
            }
        } catch (Throwable e) {
        }
        try {
            if (saida != null) {
                saida.close();
            }
        } catch (Throwable e) {
        }

    }

    public static void fim() {
        midlet.notifyDestroyed();
    }
    
    public static void mostra(Form tela){
        Display.getDisplay(CRBluetoothME.midlet).setCurrent(tela);
    }
    
    public static void mostraMsgErro(String msg, Form proximo){
        Alert alert = new Alert("CRBluetooth", msg, null, AlertType.ERROR);
        alert.setTimeout(Alert.FOREVER);
        Display.getDisplay(CRBluetoothME.midlet).setCurrent(alert, proximo);
    }
}
