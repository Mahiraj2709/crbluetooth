package requisicoes;

import java.awt.event.KeyEvent;
import principal.CRBluetoothServer;
import utils.Constantes;

public class RequisicaoTeclaEspecial implements Requisicao {

    public static final int TECLA_A = 0;
    public static final int TECLA_B = 1;
    public static final int TECLA_C = 2;
    public static final int TECLA_D = 3;
    private int tecla = -1;
    private int key = -1;

    public RequisicaoTeclaEspecial(int tecla) {
        this.tecla = tecla;
        this.avaliar();
    }

    public void executa() {

        try {

            CRBluetoothServer.robot.keyPress(key);
            CRBluetoothServer.robot.keyRelease(key);

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public void avaliar() {
        int indiceSel = -1;

        switch (tecla) {
            case TECLA_A:
                indiceSel = CRBluetoothServer.indiceA;
                break;
            case TECLA_B:
                indiceSel = CRBluetoothServer.indiceB;
                break;
            case TECLA_C:
                indiceSel = CRBluetoothServer.indiceC;
                break;
            case TECLA_D:
                indiceSel = CRBluetoothServer.indiceD;
                break;
        }
        
        if(indiceSel < Constantes.botoes.length){
            key = Constantes.teclas[indiceSel];
            return;
        }
        
        indiceSel = indiceSel - Constantes.botoes.length;
        
        if(indiceSel < 10){
            key = indiceSel + 48;
            return;
        }
        
        indiceSel = indiceSel - 10;
        key = indiceSel + 65;        

    }
}
