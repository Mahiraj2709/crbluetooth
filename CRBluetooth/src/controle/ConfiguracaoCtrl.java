package controle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.prefs.Preferences;
import principal.CRBluetoothServer;
import telas.SysTrayIcone;
import utils.Constantes;

public class ConfiguracaoCtrl {

    public void salvarConfiguracao(int indiceA, int indiceB, int indiceC, int indiceD, int indiceMouse) {
        CRBluetoothServer.indiceA = indiceA;
        CRBluetoothServer.indiceB = indiceB;
        CRBluetoothServer.indiceC = indiceC;
        CRBluetoothServer.indiceD = indiceD;
        CRBluetoothServer.indiceMouse = indiceMouse;

        Preferences pref;

        try {

            pref = Preferences.userRoot().node("CRBluetooth.configuracao");           

            pref.putInt("indiceA", indiceA);
            pref.putInt("indiceB", indiceB);
            pref.putInt("indiceC", indiceC);
            pref.putInt("indiceD", indiceD);
            pref.putInt("indiceMouse", indiceMouse);  

        } catch (Throwable e) {
            SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, 
                    Constantes.MSG_ERRO_SALVAR_CONF, SysTrayIcone.MSG_ERRO);
        } 
    }

    public void recuperarConfiguracao() {

         Preferences pref;

        try {

            pref = Preferences.userRoot().node("CRBluetooth.configuracao");            

            CRBluetoothServer.indiceA = pref.getInt("indiceA", 0);
            CRBluetoothServer.indiceB = pref.getInt("indiceB", 1);
            CRBluetoothServer.indiceC = pref.getInt("indiceC", 2);
            CRBluetoothServer.indiceD = pref.getInt("indiceD", 5);
            CRBluetoothServer.indiceMouse = pref.getInt("indiceMouse", 2);

        } catch (Throwable e) {
            SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, 
                    Constantes.MSG_ERRO_CARREGAR_CONF, SysTrayIcone.MSG_ERRO);
        } 
    }
}
