package br.com.luigiceschim.desafioitau.transacao;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private  List<TransacaoRequest> transacoes = new ArrayList<>();


    public void add(TransacaoRequest transacaoRequest){
        transacoes.add(transacaoRequest);

    }
    public void remove(){
        transacoes.clear();

    }
}
