package com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 7007848362940823021L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idperfil")
	private Integer id=0;

	@Column(name = "nome", unique=true, nullable = false, length = 50)
	private String nome;

	@Column(name = "ativo")
	private boolean ativo;

	//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
    //private Set<Funcao> funcoes;
	
	//@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinTable(name = "usuario", joinColumns = { 
	//		@JoinColumn(name = "id", nullable = false, updatable = false) }, 
	//		inverseJoinColumns = { @JoinColumn(name = "id", 
	//				nullable = false, updatable = false) })
    //private Set<Usuario> usuarios;

	public Perfil () {
		
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

	/*public Set<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(Set<Funcao> funcoes) {
		this.funcoes = funcoes;
	}*/
	
	@Override
	public String toString() {
		return getNome();
	}
	
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
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}




}
