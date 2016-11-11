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

import com.stefanini.model.Tipoinfracao;
import com.stefanini.service.TipoinfracaoService;

@Path("/tipoInfracao")
@RequestScoped
public class TipoInfracaoController {

	@Inject
	TipoinfracaoService tipoInfracaoService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tipoinfracao> get() {
		return tipoInfracaoService.listar();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void post(Tipoinfracao tipoInfracao) {
		this.tipoInfracaoService.incluir(tipoInfracao);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void put(Tipoinfracao tipoInfracao) {
		this.tipoInfracaoService.alterar(tipoInfracao);
	}

	@POST 
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(Tipoinfracao tipoInfracao) {
		this.tipoInfracaoService.remover(tipoInfracao.getIdTipoInfracao());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Controle Salvar(Tipoinfracao tipoInfracao) {
		Controle controle = new Controle();
		try {
			controle.setSucesso("Dados inseridos com sucesso");
		} catch (Exception e) {
			controle.setErro("Erro ao inserir dados" + e.getMessage());
		}
		return controle;
	}

}
