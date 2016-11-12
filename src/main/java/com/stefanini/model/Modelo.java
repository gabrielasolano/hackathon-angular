package com.stefanini.model;
// Generated 07/11/2016 12:05:08 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo generated by hbm2java
 */
@Entity
@Table(name = "modelo", catalog = "hackaton")
public class Modelo implements java.io.Serializable {

	private Integer idModelo;
	private int idCategoria;
	private String descricaoModelo;

	public Modelo() {
	}

	public Modelo(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Modelo(int idCategoria, String descricaoModelo) {
		this.idCategoria = idCategoria;
		this.descricaoModelo = descricaoModelo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idModelo", unique = true, nullable = false)
	public Integer getIdModelo() {
		return this.idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	@Column(name = "idCategoria", nullable = false)
	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "descricaoModelo", length = 50)
	public String getDescricaoModelo() {
		return this.descricaoModelo;
	}

	public void setDescricaoModelo(String descricaoModelo) {
		this.descricaoModelo = descricaoModelo;
	}

}
