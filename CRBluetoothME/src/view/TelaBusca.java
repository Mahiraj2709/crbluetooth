package view;

import comm.ConectaServico;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import main.CRBluetoothME;
import util.Constantes;

public class TelaBusca extends Form implements CommandListener {

    private Command cmConectar, cmVoltar;
    
    private ChoiceGroup cgDispositivos;
    
    public TelaBusca() {
        super("CRBluetooth - Busca serviço");
        
        cmConectar = new Command("Conectar", Command.ITEM, 0);
        cmVoltar = new Command("Voltar", Command.BACK, 1);
        
        append("Buscando serviço...");
        
        
        setCommandListener(this);
    }
    
    public void atualizarDispositivos(){
        this.deleteAll();
        this.removeCommand(cmConectar);
        this.removeCommand(cmVoltar);
        
        if(CRBluetoothME.devices.size() != 0){
            cgDispositivos = new ChoiceGroup("Dispositivos:", ChoiceGroup.EXCLUSIVE);            
            for(int i = 0; i < CRBluetoothME.devices.size(); i++){
                cgDispositivos.append((String) CRBluetoothME.devices.elementAt(i), null);
            }
            this.append(cgDispositivos);
            this.addCommand(cmConectar);
        }else{
            this.append("Nenhum dispositivo encontrado!"); 
        }
        this.addCommand(cmVoltar);
    }
    
    public void commandAction(Command cmd, Displayable arg1) {
        if(cmd == cmVoltar){
            CRBluetoothME.mostra(TelaPrincipal.getInstancia());
        }
        if(cmd == cmConectar){
            int selecionado = cgDispositivos.getSelectedIndex();
            if(selecionado != -1){
                CRBluetoothME.mostra(TelaPrincipal.getInstancia());
                CRBluetoothME.selecionado = selecionado;
                ConectaServico conecta = new ConectaServico(TelaPrincipal.getInstancia());                
                conecta.conectar();
            }else{
                CRBluetoothME.mostraMsgErro(Constantes.TXT_SELECIONE_OPCAO, this);
            }
        }
    }    

}
