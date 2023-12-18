package com.generation.aquarelando.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome obrigatorio, não pode ser em branco!")
	@Size(min = 5, max = 30)
	@Column(length = 30)
	private String nome;
	
	@NotBlank(message = "Descrição não pode estar em branco")
	@Size(min = 5, max = 100)
	@Column(length = 100)
	private String descricao;
	
	private Date data_validade;   
	
	@NotNull(message = "Quantidade não pode estar em branco")
	private int quantidade;
	
	@NotBlank(message = "Foto não pode estar em branco")
	private String foto;
	
	@Column(columnDefinition="tinyint(1) default 0")
	private boolean selo_inmetro = false;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getData_validade() {
		return data_validade;
	}

	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean isSelo_inmetro() {
		return selo_inmetro;
	}

	public void setSelo_inmetro(boolean selo_inmetro) {
		this.selo_inmetro = selo_inmetro;
	}
	
	
}
