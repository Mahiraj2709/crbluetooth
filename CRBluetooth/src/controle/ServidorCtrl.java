package controle;

import comunicacao.ConexaoBluetooth;
import comunicacao.IniciarServicoBluetooth;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import principal.CRBluetoothServer;
import telas.SysTrayIcone;
import utils.Constantes;

public class ServidorCtrl {

    public void iniciarServidor() {

        IniciarServicoBluetooth servico = new IniciarServicoBluetooth();
        Thread t = new Thread(servico);
        t.start();

        SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, Constantes.MSG_SERVIDOR_INICIADO, SysTrayIcone.MSG_INFO);

        SysTrayIcone.getInstance().setIniciado(true);

    }

    public void pararServidor() {

        if (CRBluetoothServer.conexao != null) {
            clienteDesconectado();
        }
        if (CRBluetoothServer.servico != null) {
            try {
                CRBluetoothServer.servico.close();
                CRBluetoothServer.servico = null;
            } catch (IOException ex) {
            }
        }
        SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, Constantes.MSG_SERVIDOR_PARADO, SysTrayIcone.MSG_INFO);
        SysTrayIcone.getInstance().setIniciado(false);
    }

    public void clienteConectado() {

        try {
            CRBluetoothServer.robot = new Robot();
        } catch (AWTException e) {
            SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, Constantes.MSG_ERRO_CRIAR_ROBOT, SysTrayIcone.MSG_ERRO);
            return;
        }

        ConexaoBluetooth conBluetooth = new ConexaoBluetooth();
        Thread t = new Thread(conBluetooth);
        t.start();

        SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, Constantes.MSG_DISPOSITIVO_CONECTADO, SysTrayIcone.MSG_INFO);
        SysTrayIcone.getInstance().setConectado(true);
    }

    public void desconectarCliente() {

        try {
            if (CRBluetoothServer.entrada != null) {
                CRBluetoothServer.entrada.close();
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public void clienteDesconectado() {

        CRBluetoothServer.robot = null;

        try {
            if (CRBluetoothServer.saida != null) {
                try {
                    CRBluetoothServer.saida.writeUTF(Constantes.STR_FECHA_CONEXAO);
                } catch (Throwable e4) {
                    e4.printStackTrace();
                }
                CRBluetoothServer.saida.close();
                CRBluetoothServer.saida = null;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            if (CRBluetoothServer.entrada != null) {
                CRBluetoothServer.entrada.close();
                CRBluetoothServer.entrada = null;
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            if (CRBluetoothServer.conexao != null) {
                CRBluetoothServer.conexao.close();
                CRBluetoothServer.conexao = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA, Constantes.MSG_DISPOSITIVO_DESCONECTADO, SysTrayIcone.MSG_INFO);
        SysTrayIcone.getInstance().setConectado(false);

    }

    public void fecharServidor() {        
        pararServidor();
        System.exit(0);
    }
}
