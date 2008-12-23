package utils;

import java.awt.event.KeyEvent;

public interface Constantes {

    public final String NOME_PROGRAMA = "CRBluetooth";
    public final String SERVICE_UUID = "061020070110198603091986";
    
    public final String MSG_ERRO_SALVAR_CONF = "Impossível salvar as configurações!";
    public final String MSG_ERRO_CARREGAR_CONF = "Impossível carregar as configurações!";
    public final String MSG_SERVICO_DESCONHECIDO = "Serviço desconhecido: ";
    public final String MSG_DISPOSITIVO_CONECTADO = "Dispositivo remoto conectado!";
    public final String MSG_DISPOSITIVO_DESCONECTADO = "Dispositivo remoto desconectado!";
    
    public final String MSG_SERVIDOR_INICIADO = "Serviço iniciado!";
    public final String MSG_SERVIDOR_PARADO = "Serviço parado!";
    public final String MSG_ERRO_CRIAR_ROBOT = "Impossível criar Robot";    
            
    public final String STR_FECHA_CONEXAO = "//CRB/FECHA";
    
    public final String SERVICO_MOUSE_UP = "//CRB/UP";
    public final String SERVICO_MOUSE_DOWN = "//CRB/DOWN";
    public final String SERVICO_MOUSE_LEFT = "//CRB/LEFT";
    public final String SERVICO_MOUSE_RIGHT = "//CRB/RIGHT";
    
    public final String SERVICO_MOUSE_CLICK = "//CRB/CLICK";
    
    public final String SERVICO_TECLA_A = "//CRB/GAME_A";
    public final String SERVICO_TECLA_B = "//CRB/GAME_B";
    public final String SERVICO_TECLA_C = "//CRB/GAME_C";
    public final String SERVICO_TECLA_D = "//CRB/GAME_D";
    
    public final String TXT_KEY_INVALIDA = "Teclas não encontradas: ";
    
    public final String[] botoes = {"Enter", "Backspace", "Espaço", "Alt", "Ctrl", "Tab", "Delete",
    "Insert","Home","End","Page Up", "Page Down", "Up", "Down", "Left", "Right"};
    
    public final int[] teclas = {KeyEvent.VK_ENTER, KeyEvent.VK_BACK_SPACE, KeyEvent.VK_SPACE,
    KeyEvent.VK_ALT, KeyEvent.VK_CONTROL, KeyEvent.VK_TAB, KeyEvent.VK_DELETE,
    KeyEvent.VK_INSERT, KeyEvent.VK_HOME, KeyEvent.VK_END, KeyEvent.VK_PAGE_UP,
    KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT};
    
}
