/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comm;

import java.io.EOFException;
import java.io.IOException;
import main.CRBluetoothME;
import util.Constantes;
import view.TelaPrincipal;

/**
 *
 * @author Elio
 */
public class TestaConexao implements Runnable {

    public void run() {

        try {

            String lido = "";
            while (!lido.equals(Constantes.STR_FECHA_CONEXAO)) {
                lido = CRBluetoothME.entrada.readUTF();
                TelaPrincipal.getInstancia().addTexto("lido: " + lido);
            }

        } catch (Throwable e) {
            
        } finally {
            DesconectaServico desconecta = new DesconectaServico();
            desconecta.desconectar();
        }
    }
}
