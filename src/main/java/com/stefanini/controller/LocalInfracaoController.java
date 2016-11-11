package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Localinfracao;
import com.stefanini.service.LocalinfracaoService;

@Path("/localInfracao")
@RequestScoped
public class LocalInfracaoController {

	
		@Inject
		LocalinfracaoService localInfracaoService;
	
	 	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Localinfracao> get() {
	 		return localInfracaoService.listar();
	    }
	 	
	 	@POST
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void post(Localinfracao localInfracao){
	 		this.localInfracaoService.incluir(localInfracao);
	 	}
	 	
	 	@PUT
	 	@Path("/{id}")
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void put(Localinfracao localInfracao){
	 		this.localInfracaoService.alterar(localInfracao);
	 	}
	 	
	 	@POST /*No service do js eh especificado o tipo de request (post, get, delete, put, etc)*/
	 	@Path("/deletar")
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void delete(Localinfracao localInfracao){
	 		this.localInfracaoService.remover(localInfracao.getIdLocalInfracao());
	 	}
	 	
	 	
	 	@POST
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	public Controle Salvar(Localinfracao localInfracao){
	 		Controle controle = new Controle();
	 		try{
	 			controle.setSucesso("Dados inseridos com sucesso");
	 		}catch(Exception e){
	 			controle.setErro("Erro ao inserir dados" + e.getMessage());
	 		}
	 		return controle;
	 	}

}
