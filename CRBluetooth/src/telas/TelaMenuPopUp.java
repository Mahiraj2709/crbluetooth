package telas;

import controle.ServidorCtrl;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenuPopUp extends PopupMenu {

    private ServidorCtrl servidorCtrl = new ServidorCtrl();
    
    private MenuItem itemSair;
    private MenuItem itemIniciar;
    private MenuItem itemParar;
    private MenuItem itemDesconectar;
    private MenuItem itemConfigurar;    

    public TelaMenuPopUp() {

        itemIniciar = new MenuItem("Iniciar");
        itemParar = new MenuItem("Parar");
        itemDesconectar = new MenuItem("Desconectar");
        itemConfigurar = new MenuItem("Configurações");        
        itemSair = new MenuItem("Sair");

        itemSair.addActionListener(eventoSair);
        itemIniciar.addActionListener(eventoIniciar);
        itemParar.addActionListener(eventoParar);
        itemDesconectar.addActionListener(eventoDesconectar);   
        itemConfigurar.addActionListener(eventoConfigurar);

        this.add(itemIniciar);
        this.addSeparator();
        this.add(itemConfigurar);        
        this.addSeparator();
        this.add(itemSair);
    }

    public void setConectado(boolean conectado) {
        if (conectado) {
            this.insert(itemDesconectar, 1);
        } else {
            this.remove(itemDesconectar);
        }
    }

    public void setIniciado(boolean iniciado) {
        if (iniciado) {
            this.remove(itemIniciar);
            this.insert(itemParar, 0);
        } else {
            this.remove(itemParar);
            this.insert(itemIniciar, 0);
        }
    }
    private ActionListener eventoSair = new ActionListener() {

        public void actionPerformed(ActionEvent e) {            
            servidorCtrl.fecharServidor();
        }
    };
    private ActionListener eventoIniciar = new ActionListener() {

        public void actionPerformed(ActionEvent e) {            
            servidorCtrl.iniciarServidor();
        }
    };
    private ActionListener eventoParar = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            servidorCtrl.pararServidor();
        }
    };    
    private ActionListener eventoDesconectar = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            servidorCtrl.clienteDesconectado();
        }
    };
    private ActionListener eventoConfigurar = new ActionListener() {

        public void actionPerformed(ActionEvent e) {            
            TelaConfiguracao tela = TelaConfiguracao.getInstance();
            Insets in = Toolkit.getDefaultToolkit().getScreenInsets(tela.getGraphicsConfiguration());
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            tela.setLocation((d.width - (in.left + in.top)) - tela.getWidth(),(d.height - (in.top + in.bottom)) - tela.getHeight());
            TelaConfiguracao.getInstance().setVisible(true);
        }
    };
}
