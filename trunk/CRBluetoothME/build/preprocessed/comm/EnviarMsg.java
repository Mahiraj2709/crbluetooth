/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comm;

import main.CRBluetoothME;

/**
 *
 * @author Elio
 */
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
