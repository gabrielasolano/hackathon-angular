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

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;

@Path("/agente")
@RequestScoped
public class AgenteController {
	
		@Inject
		AgenteService agenteService;
	
	 	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Agente> get() {
	 		return agenteService.listar();
	    }
	 	
	 	@POST
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void post(Agente agente){
	 		this.agenteService.incluir(agente);
	 	}
	 	
	 	@PUT
	 	@Path("/{id}")
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void put(Agente agente){
	 		this.agenteService.alterar(agente);
	 	}
	 	
	 	@POST
	 	@Path("deletar/{id}")
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void put(Integer id){
	 		this.agenteService.remover(id);
	 	}
	 	
	 	
	 	@POST
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	public Controle Salvar(Agente agente){
	 		Controle controle = new Controle();
	 		try{
	 			controle.setSucesso("Dados inseridos com sucesso");
	 		}catch(Exception e){
	 			controle.setErro("Erro ao inserir dados" + e.getMessage());
	 		}
	 		return controle;
	 	}

}
