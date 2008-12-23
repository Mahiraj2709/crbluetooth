package comm;

import main.CRBluetoothME;
import util.Constantes;
import view.TelaPrincipal;

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
