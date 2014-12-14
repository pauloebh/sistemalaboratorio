package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = -8772516708049621911L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Integer id=0;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "email", unique = true, length = 50)
	private String email;

	@Column(name = "senha", length = 200)
	private String senha;

	@Column(name = "ativo")
	private Boolean ativo;

	@Column(name = "contatoPrincipal", nullable = true)
	private Boolean contatoPrincipal;

    @ManyToOne(optional = true, fetch=FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    //@OneToMany(mappedBy = "usuario")
	//private List<Log> logs;

	//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	//private Set<Perfil> perfis;
    

	public Usuario () {
		
	}
	
	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean isContatoPrincipal() {
		return contatoPrincipal;
	}

	public void setContatoPrincipal(boolean contatoPrincipal) {
		this.contatoPrincipal = contatoPrincipal;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/*public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}*/

	/*private List<Perfil> getPerfis() {
		return perfis;
	}

	private void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




}
