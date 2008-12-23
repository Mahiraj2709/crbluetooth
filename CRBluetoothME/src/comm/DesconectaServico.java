package comm;

import main.CRBluetoothME;
import util.Constantes;
import view.TelaPrincipal;

public class DesconectaServico {

    public void desconectar() {
        if (CRBluetoothME.saida != null) {
            try {

                EnviarMsg.enviar(Constantes.STR_FECHA_CONEXAO);

            } catch (Throwable e) {
            }
        }

        try {
            try {
                if (CRBluetoothME.saida != null) {
                    CRBluetoothME.saida.close();
                    CRBluetoothME.saida = null;
                }
            } catch (Throwable e3) {
            }
            try {
                if (CRBluetoothME.entrada != null) {
                    CRBluetoothME.entrada.close();
                    CRBluetoothME.entrada = null;
                }
            } catch (Throwable e3) {
            }

            try {
                if (CRBluetoothME.streamConnection != null) {
                    CRBluetoothME.streamConnection.close();
                    CRBluetoothME.streamConnection = null;
                }
            } catch (Throwable e3) {
            }

            TelaPrincipal.getInstancia().atualizaDesconectado();

        } catch (Throwable e2) {
            TelaPrincipal.getInstancia().addTexto(Constantes.ERRO_DESCONECTAR);
            TelaPrincipal.getInstancia().addTexto("Desc: " + e2.getMessage());
        }    
    }

}
