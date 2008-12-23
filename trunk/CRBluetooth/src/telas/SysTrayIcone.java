package telas;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.net.URL;

public class SysTrayIcone {

    public static final int MSG_NONE = 0;
    public static final int MSG_INFO = 1;
    public static final int MSG_ERRO = 2;
    private static SysTrayIcone instancia;
    private SystemTray tray;
    private Image image;
    private TrayIcon trayIcon;
    private TelaMenuPopUp popup;

    private SysTrayIcone() {
        instancia = this;
        if (SystemTray.isSupported()) {

            tray = SystemTray.getSystemTray();
            URL imageURL = getClass().getClassLoader().getResource("recursos/iconepadrao.png");
            image = Toolkit.getDefaultToolkit().createImage(imageURL);

            popup = new TelaMenuPopUp();
            trayIcon = new TrayIcon(image, "CRBluetooth", popup);

            trayIcon.setImageAutoSize(true);
        }
    }

    public static SysTrayIcone getInstance() {
        if (instancia == null) {
            instancia = new SysTrayIcone();
        }
        return instancia;
    }

    public void mostra(boolean mostra) {
        try {
            if (mostra) {
                tray.add(trayIcon);
            } else {
                tray.remove(trayIcon);
            }
        } catch (AWTException e) {
            System.err.println("TrayIcon could not be added.");
        }
    }

    public void setImage(String caminho) {

        try {
            URL imageURL = getClass().getClassLoader().getResource(caminho);
            image = Toolkit.getDefaultToolkit().createImage(imageURL);
            trayIcon.setImage(image);
        } catch (Throwable e) {
            trayIcon.displayMessage("Erro!", "" + e, TrayIcon.MessageType.ERROR);
        }
    }

    public void setIniciado(boolean iniciado) {
        if (iniciado) {
            setImage("recursos/iconestart.png");
            trayIcon.setToolTip("CRBluetooth - Serviço iniciado!");
        } else {
            setImage("recursos/iconepadrao.png");
            trayIcon.setToolTip("CRBluetooth");
        }        
        popup.setIniciado(iniciado);
    }

    public void setConectado(boolean conectado) {
        if (conectado) {
            setImage("recursos/iconecon.png");
            trayIcon.setToolTip("CRBluetooth - Dispositivo remoto conectado!");
        } else {
            setImage("recursos/iconestart.png");
            trayIcon.setToolTip("CRBluetooth - Serviço iniciado!");
        }
        popup.setConectado(conectado);
    }

    public void mostraMensagem(String titulo, String txt, int tipo) {
        switch (tipo) {
            case MSG_INFO:
                trayIcon.displayMessage(titulo, txt, TrayIcon.MessageType.INFO);
                break;
            case MSG_ERRO:
                trayIcon.displayMessage(titulo, txt, TrayIcon.MessageType.ERROR);
                break;
            default:
                trayIcon.displayMessage(titulo, txt, TrayIcon.MessageType.NONE);

        }

    }
}

