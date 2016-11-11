package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Localinfracao;
import com.stefanini.repository.LocalinfracaoRepository;

@Stateless
public class LocalinfracaoService {
    @Inject
    private LocalinfracaoRepository localInfracaoRepository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void incluir(Localinfracao localInfracao){
    	localInfracaoRepository.incluir(localInfracao);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Localinfracao> listar(){
    	return localInfracaoRepository.lista();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void alterar(Localinfracao localInfracao){
    	localInfracaoRepository.altera(localInfracao);
    	
    }
      
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(Integer id){
    	localInfracaoRepository.remove(id);
    }
}
