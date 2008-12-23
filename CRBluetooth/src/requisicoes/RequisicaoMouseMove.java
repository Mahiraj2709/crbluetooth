package requisicoes;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import principal.CRBluetoothServer;

public class RequisicaoMouseMove implements Requisicao {

    public static final int EIXO_AVANCA = 1;
    public static final int EIXO_PARADO = 0;
    public static final int EIXO_RECUA = -1;
    private int x;
    private int y;    

    public RequisicaoMouseMove(int direcaoX, int direcaoY) {
        
        x = (-1) * (CRBluetoothServer.indiceMouse + 1) * direcaoX;
        y = (CRBluetoothServer.indiceMouse + 1) * direcaoY;
    }

    public void executa() {

        Point p = MouseInfo.getPointerInfo().getLocation();
        CRBluetoothServer.robot.mouseMove(p.x + x, p.y + y);
    }
}

