/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import comm.EnviarMsg;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.CustomItem;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import main.CRBluetoothME;
import util.Constantes;

/**
 *
 * @author Elio
 */
public class ItemCaptura extends CustomItem {

    private Vector conteudo;
    private Font fonte;
    private int altura;
    private int largura;
    private Integer ultimaTecla;
    private Timer timer;
    private KeyRepeatTask task;
    private int quantidade;

    public ItemCaptura(int largura, int altura) {
        super(null);
        conteudo = new Vector();
        fonte = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
        this.altura = altura - 5;
        this.largura = largura;

        setKeyRepetition();

        quantidade = (int) Math.ceil((double) altura / (double) fonte.getHeight());

    }

    public void append(String txt) {
        conteudo.addElement(txt);
        repaint();
    //altura = fonte.getHeight() * conteudo.size();
    }

    public void limpa() {
        conteudo = new Vector();
        repaint();
    }

    protected int getMinContentWidth() {
        return largura;
    }

    protected int getMinContentHeight() {
        return altura;
    }

    protected int getPrefContentWidth(int w) {
        return largura;
    }

    protected int getPrefContentHeight(int y) {
        return altura;
    }

    protected void paint(Graphics g, int w, int h) {
        //g.setStrokeStyle(Graphics.DOTTED);
        //g.drawRect(0, 0, largura - 1, altura - 1);

        int iInicio = conteudo.size() - quantidade;
        int iFinal = iInicio + quantidade - 1;

        if (iFinal > conteudo.size() - 1) {
            iFinal = conteudo.size() - 1;
        }

        if (iInicio < 0) {
            iInicio = 0;
        }

        for (int j = iInicio; j <= iFinal; j++) {
            String txt = (String) conteudo.elementAt(j);
            g.setFont(null);
            g.drawString(txt, 0, (j * fonte.getHeight()), Graphics.LEFT | Graphics.TOP);
        }

    }

    protected boolean traverse(int dir, int viewportWidth, int viewportHeight,
            int[] visRect_inout) {
        //ultimaTecla = new Integer(dir);
        /*String texto = teclou(dir);
        envia(texto);*/
        return true;
    }

    protected void keyPressed(int keyCode) {
        int key = getGameAction(keyCode);
        String texto = teclou(key);
        envia(texto);
    }

    protected void keyReleased(int keyCode) {
        ultimaTecla = null;
    }

    protected void keyRepeated(int keyCode) {
    }

    private void setKeyRepetition() {
        task = new KeyRepeatTask();
        timer = new Timer();
        timer.schedule(task, 0, 50);
    }

    private class KeyRepeatTask extends TimerTask {

        public void run() {
            if (ultimaTecla != null) {
                String texto = teclou(ultimaTecla.intValue());
                envia(texto);
            }
        }
    }

    protected String teclou(int gameKey) {
        String texto = null;
        switch (gameKey) {
            case Canvas.UP:
                texto = Constantes.SERVICO_MOUSE_UP;
                ultimaTecla = new Integer(gameKey);
                break;
            case Canvas.DOWN:
                texto = Constantes.SERVICO_MOUSE_DOWN;
                ultimaTecla = new Integer(gameKey);
                break;
            case Canvas.RIGHT:
                texto = Constantes.SERVICO_MOUSE_RIGHT;
                ultimaTecla = new Integer(gameKey);
                break;
            case Canvas.LEFT:
                texto = Constantes.SERVICO_MOUSE_LEFT;
                ultimaTecla = new Integer(gameKey);
                break;
            case Canvas.FIRE:
                texto = Constantes.SERVICO_MOUSE_CLICK;
                break;
            case Canvas.GAME_A:
                texto = Constantes.SERVICO_TECLA_A;
                break;
            case Canvas.GAME_B:
                texto = Constantes.SERVICO_TECLA_B;
                break;
            case Canvas.GAME_C:
                texto = Constantes.SERVICO_TECLA_C;
                break;
            case Canvas.GAME_D:
                texto = Constantes.SERVICO_TECLA_D;
                break;
        }
        return texto;
    }

    protected void envia(String texto) {
        if (texto != null) {
            EnviarMsg.enviar(texto);
        }
    }
}
