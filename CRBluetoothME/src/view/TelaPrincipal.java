package view;

import comm.BuscaServicos;
import comm.DesconectaServico;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import main.CRBluetoothME;
import util.Constantes;

public class TelaPrincipal extends Form implements CommandListener{
    
    private Command cmBuscar, cmDesconectar, cmSair, cmDigitar;
    private ItemCaptura item;
    
    private static TelaPrincipal instancia = null;
    
    public static TelaPrincipal getInstancia(){
        if(instancia == null)
            instancia = new TelaPrincipal();
        return instancia;
    }
    
    private TelaPrincipal(){
        super("CRBluetooth");        

        cmBuscar = new Command("Buscar Servico", Command.ITEM, 0);
        cmDesconectar = new Command("Desconectar", Command.ITEM, 1);
        cmDigitar = new Command("Digitar", Command.ITEM, 3);
        cmSair = new Command("Sair", Command.EXIT, 2);
        
        item = new ItemCaptura(this.getWidth(), this.getHeight());
        
        append(item);
        
        addCommand(cmBuscar);
        //addCommand(cmDesconectar);
        //addCommand(cmDigitar);
        addCommand(cmSair);
        
        setCommandListener(this);
    }
    
    public void addTexto(String texto){
        item.append(texto);
    }

    public void commandAction(Command com, Displayable arg1) {
        if(com == cmSair){
            CRBluetoothME.fim();
        }
        if(com == cmBuscar){
            TelaBusca tela = new TelaBusca();
            CRBluetoothME.mostra(tela);
            BuscaServicos busca = new BuscaServicos(tela);
            Thread t = new Thread(busca);
            t.start();
        }
        if(com == cmDesconectar){
            DesconectaServico desconecta = new DesconectaServico();
            desconecta.desconectar();
        }
        if(com == cmDigitar){
            CRBluetoothME.mostra(TelaDigitar.getInstancia());
        }
    }
    
    public void atualizaConectando(){
        item.limpa();
        item.append("Conectando...");
    }
    
    public void atualizaConectado(){
        item.limpa();
        item.append(Constantes.TXT_CONECTADO);
        item.append((String) CRBluetoothME.devices.elementAt(CRBluetoothME.selecionado));
        
        this.addCommand(cmDesconectar);
        this.addCommand(cmDigitar);
        this.removeCommand(cmBuscar);
        
        if(CRBluetoothME.e != null)
            this.addTexto(CRBluetoothME.e);
    }
    
    public void atualizaDesconectado(){
        item.limpa();
        item.append(Constantes.TXT_DESCONECTADO);
        item.append((String) CRBluetoothME.devices.elementAt(CRBluetoothME.selecionado));
        
        this.addCommand(cmBuscar);
        this.removeCommand(cmDesconectar);
        this.removeCommand(cmDigitar);
        
    }
    
    public void atualizaErroConexao(){
        item.limpa();
        item.append(Constantes.ERRO_CONEXAO);
        item.append((String) CRBluetoothME.devices.elementAt(CRBluetoothME.selecionado));
    }

}
