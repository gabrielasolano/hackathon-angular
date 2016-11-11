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

import com.stefanini.model.Infracoes;
import com.stefanini.service.InfracoesService;

@Path("/infracao")
@RequestScoped
public class InfracoesController {

	@Inject
	InfracoesService infracoesService;

 	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Infracoes> get() {
 		return infracoesService.listar();
    }
 	
 	@POST
 	@Consumes(MediaType.APPLICATION_JSON)
 	@Produces(MediaType.APPLICATION_JSON)
 	public void post(Infracoes infracoes){
 		this.infracoesService.incluir(infracoes);
 	}
 	
 	@PUT
 	@Path("/{id}")
 	@Consumes(MediaType.APPLICATION_JSON)
 	@Produces(MediaType.APPLICATION_JSON)
 	public void put(Infracoes infracoes){
 		this.infracoesService.alterar(infracoes);
 	}
 	
 	@POST /*No service do js eh especificado o tipo de request (post, get, delete, put, etc)*/
 	@Path("/deletar")
 	@Consumes(MediaType.APPLICATION_JSON)
 	@Produces(MediaType.APPLICATION_JSON)
 	public void delete(Infracoes infracoes){
 		this.infracoesService.remover(infracoes.getIdInfracao());
 	}
 	
 	
 	@POST
 	@Consumes(MediaType.APPLICATION_JSON)
 	public Controle Salvar(Infracoes infracoes){
 		Controle controle = new Controle();
 		try{
 			controle.setSucesso("Dados inseridos com sucesso");
 		}catch(Exception e){
 			controle.setErro("Erro ao inserir dados" + e.getMessage());
 		}
 		return controle;
 	}
}
