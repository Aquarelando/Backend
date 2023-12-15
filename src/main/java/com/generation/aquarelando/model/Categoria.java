package com.generation.aquarelando.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Por favor, informe o nome da Categoria!")
	@Size(min = 5, max = 20, message = "O nome da categoris deve ter no minimo 5  e no maximo 20 caracteres.")
	@Column(length = 20)
	private String nome;
	
	@NotBlank(message = "Por favor, informe a descrição da Categoria!")
	@Size(min = 10, max = 500, message = "A descrição da categoria deve ter no minimo 10 e no maximo 500 caracteres.")
	@Column(length = 500)
	private String descricao;
	
	@Column(columnDefinition="tinyint(1) default 1")
	private boolean disponivel = true;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	
}
