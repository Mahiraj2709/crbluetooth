package requisicoes;

import java.awt.event.InputEvent;
import principal.CRBluetoothServer;

public class RequisicaoMouseClique implements Requisicao {

    public void executa() {
        CRBluetoothServer.robot.mousePress(InputEvent.BUTTON1_MASK);
        CRBluetoothServer.robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
