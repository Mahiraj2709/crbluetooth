package requisicoes;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import principal.CRBluetoothServer;
import telas.SysTrayIcone;
import utils.Constantes;

public class RequisicaoTeclado implements Requisicao {

    private String texto;
    private String resposta = "";
    private ArrayList<Character> naoEncontrados = new ArrayList<Character>();

    public RequisicaoTeclado(String t) {
        this.texto = t;
    }

    public void executa() {

        texto = texto.toUpperCase();

        int keyAnterior = -1;

        for (int i = 0; i < texto.length(); i++) {
            int c = texto.charAt(i);
            int key = avaliar(c);

            if (keyAnterior != -1) {
                CRBluetoothServer.robot.keyRelease(keyAnterior);
            }

            if (key == -1) {
                configuraNaoEncontradas(i);
            } else {
                try {
                    CRBluetoothServer.robot.keyPress(key);
                    keyAnterior = key;
                } catch (Throwable e) {
                    configuraNaoEncontradas(i);
                    keyAnterior = -1;
                }
            }
        }

        if (!resposta.equals("")) {
            SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, resposta, SysTrayIcone.MSG_INFO);
        }

    }

    public void configuraNaoEncontradas(int indice) {
        if (resposta.equals("")) {
            resposta = Constantes.TXT_KEY_INVALIDA;
        }

        Character c = new Character(texto.charAt(indice));

        if (!naoEncontrados.contains(c)) {
            resposta += "\"" + texto.charAt(indice) + "\" ";
            naoEncontrados.add(c);
        }
    }

    public int avaliar(int c) {

        //Numeros
        if (c >= 48 && c <= 57) {
            return c;
        }

        //Letras
        if (c >= 65 && c <= 90) {
            return c;
        }

        switch (c) {
            //'
            case 39:
                return KeyEvent.VK_QUOTE;
            ///
            case 47:
                return KeyEvent.VK_DIVIDE;
            //*
            case 42:
                return KeyEvent.VK_MULTIPLY;
            //+
            case 43:
                return KeyEvent.VK_ADD;
            //-
            case 45:
            //=
            case 61:
            //[
            case 91:
            //]
            case 93:
            //\
            case 92:
            //,
            case 44:
            //.
            case 46:
            //;
            case 59:
            //" "
            case 32:
                return c;
        }
        return -1;
    }
}

