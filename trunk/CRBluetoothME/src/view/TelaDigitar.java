package view;

import comm.EnviarMsg;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import main.CRBluetoothME;

public class TelaDigitar extends Form implements CommandListener {

    private Command cmCancelar, cmEnviar, cmLimpar;
    private TextField tfDigitar;
    
    private static TelaDigitar instancia;
    
    public static TelaDigitar getInstancia(){
        if(instancia == null)
            instancia = new TelaDigitar();
        return instancia;
    }
    
    private TelaDigitar(){
        super("CRBluetooth - Digitar");
        
        tfDigitar = new TextField("Teclas:", "", 128, TextField.ANY);
        
        append(tfDigitar);
        
        cmEnviar = new Command("Enviar", Command.OK, 0);
        cmCancelar = new Command("Cancelar", Command.CANCEL, 1);
        cmLimpar = new Command("Limpar", Command.ITEM, 2);
        
        addCommand(cmEnviar);
        addCommand(cmCancelar);
        addCommand(cmLimpar);
        
        setCommandListener(this);
    }

    public void commandAction(Command com, Displayable arg1) {
        if(com == cmCancelar){
            CRBluetoothME.mostra(TelaPrincipal.getInstancia());
        }
        if(com == cmEnviar){
            if(tfDigitar.getString().equals("")){
                CRBluetoothME.mostraMsgErro("Informe pelo menos uma tecla", this);
            }else{
                EnviarMsg.enviar(tfDigitar.getString());
                CRBluetoothME.mostra(TelaPrincipal.getInstancia());
            }
        }
        if(com == cmLimpar){
            tfDigitar.setString("");
        }             
    }
    
}
