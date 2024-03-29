package com.generation.aquarelando.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

	private LocalDate dataValidade;

	@NotNull(message = "Quantidade não pode estar em branco")
	private int quantidade;

	@NotBlank(message = "Foto não pode estar em branco")
	private String foto;

	//@Column(columnDefinition = "tinyint(1) default 0")
	private boolean seloInmetro = false;

	@NotNull(message = "Informe o Preço do Produto!")
	@Positive(message = "O preço do Produto deve ser maior que zero!")
	private float preco;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

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

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
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

	public boolean isSeloInmetro() {
		return seloInmetro;
	}

	public void setSeloInmetro(boolean seloInmetro) {
		this.seloInmetro = seloInmetro;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
