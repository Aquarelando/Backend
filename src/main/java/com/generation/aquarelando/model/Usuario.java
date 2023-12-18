package com.generation.aquarelando.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name="tb_usuario")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Obrigatorio Usuario, Não pode ter somentes espaços em brancos.")
    @Size(min = 5,max = 50, message = "Min:5 e Max: 50")
    @Column(length = 50)
    private String nome;
    
    @NotBlank(message = "Não pode ter espaços vazios")
    @Temporal(TemporalType.DATE)
    private Date data_nascimento;
    
    @NotBlank(message = "Obrigatorio CPF, Não pode ter espaços em brancos, nem pontuações ou traços.")
    @Size(min = 11,max = 11)
    private String cpf;
    
    private String foto;
    
    @NotBlank(message = "Obrigatorio Email, Não pode ter somentes espaços em brancos.")
    @Size(min = 11,max = 11)
    private String email;

    @NotBlank(message = "Obrigatorio senha, precisa ter caracteres especiais e pelo menos uma letra maiuscula")
    @Size(min = 11,max = 11)
    private String senha;

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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

    
}
		
		
