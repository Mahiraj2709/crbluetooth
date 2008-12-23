package controle;

import requisicoes.Requisicao;
import requisicoes.RequisicaoMouseClique;
import requisicoes.RequisicaoMouseMove;
import requisicoes.RequisicaoTeclaEspecial;
import requisicoes.RequisicaoTeclado;
import telas.SysTrayIcone;
import utils.Constantes;

public class ServicoCtrl {

    Requisicao requisicao = null;

    public void avaliar(String operacao) {

        requisicao = null;

        if (operacao.equals(Constantes.SERVICO_MOUSE_LEFT)) {
            requisicao = new RequisicaoMouseMove(RequisicaoMouseMove.EIXO_AVANCA, RequisicaoMouseMove.EIXO_PARADO);
        }else{
        if (operacao.equals(Constantes.SERVICO_MOUSE_RIGHT)) {
            requisicao = new RequisicaoMouseMove(RequisicaoMouseMove.EIXO_RECUA, RequisicaoMouseMove.EIXO_PARADO);
        }else{
        if (operacao.equals(Constantes.SERVICO_MOUSE_UP)) {
            requisicao = new RequisicaoMouseMove(RequisicaoMouseMove.EIXO_PARADO, RequisicaoMouseMove.EIXO_RECUA);
        }else{
        if (operacao.equals(Constantes.SERVICO_MOUSE_DOWN)) {
            requisicao = new RequisicaoMouseMove(RequisicaoMouseMove.EIXO_PARADO, RequisicaoMouseMove.EIXO_AVANCA);
        }else{
        if(operacao.equals(Constantes.SERVICO_MOUSE_CLICK)){
            requisicao = new RequisicaoMouseClique();
        }else{
        if(operacao.equals(Constantes.SERVICO_TECLA_A)){
            requisicao = new RequisicaoTeclaEspecial(RequisicaoTeclaEspecial.TECLA_A);
        }else{
        if(operacao.equals(Constantes.SERVICO_TECLA_B)){
            requisicao = new RequisicaoTeclaEspecial(RequisicaoTeclaEspecial.TECLA_B);
        }else{
        if(operacao.equals(Constantes.SERVICO_TECLA_C)){
            requisicao = new RequisicaoTeclaEspecial(RequisicaoTeclaEspecial.TECLA_C);
        }else{
        if(operacao.equals(Constantes.SERVICO_TECLA_D)){
            requisicao = new RequisicaoTeclaEspecial(RequisicaoTeclaEspecial.TECLA_D);
        }else{
            requisicao = new RequisicaoTeclado(operacao);
        }}}}}}}}}

        if (requisicao != null) {
            requisicao.executa();
        } else {
            SysTrayIcone.getInstance().mostraMensagem(Constantes.NOME_PROGRAMA + " - Erro",
                    Constantes.MSG_SERVICO_DESCONHECIDO + operacao,
                    SysTrayIcone.MSG_ERRO);
        }

    }
}
