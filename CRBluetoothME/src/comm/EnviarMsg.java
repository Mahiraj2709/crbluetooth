package comm;

import main.CRBluetoothME;

public class EnviarMsg {

    public static void enviar(String msg) {

        if (CRBluetoothME.saida != null) {
            try {
                CRBluetoothME.saida.writeUTF(msg);
                CRBluetoothME.saida.flush();
            } catch (Throwable e) {
                DesconectaServico desconecta = new DesconectaServico();
                desconecta.desconectar();                
            }
        }
    }
}
