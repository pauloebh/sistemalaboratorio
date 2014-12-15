package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = -8772516708049621911L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private Integer id=0;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "email", unique = true, length = 50)
	private String email;

	private String senha;
	private boolean ativo=true;
	
	@Column(name = "contatoprincipal")
	private boolean contatoPrincipal=true;

	@Column(name="dddtelcelular")
	private String  dddTelCelular;
	
	@Column(name="telcelular")
	private String telCelular;
	
	@Column(name="dddtelcomercial")
	private String dddTelComercial;
	
	@Column(name="telcomercial")
	private String telComercial;
	
    @ManyToOne(optional = true, fetch=FetchType.EAGER)
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    //@OneToMany(mappedBy = "usuario")
	//private List<Log> logs;

	//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	//private Set<Perfil> perfis;
    
    
    @ManyToMany(
	        targetEntity=Perfil.class,
	        cascade={CascadeType.PERSIST, CascadeType.MERGE}
	    )
	    @JoinTable(
	        name="Perfil_usuario",
	        joinColumns=@JoinColumn(name="level_id"),
	        inverseJoinColumns=@JoinColumn(name="Perfil_id")
	    )	
	private List <Perfil> Perfis;
    

	public Usuario () {
		
	}
	
	public List<Perfil> getPerfis() {
		return Perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		Perfis = perfis;
	}
	
	public boolean isAtivo() {
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

	public String getDddTelCelular() {
		return dddTelCelular;
	}

	public void setDddTelCelular(String dddTelCelular) {
		this.dddTelCelular = dddTelCelular;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getDddTelComercial() {
		return dddTelComercial;
	}

	public void setDddTelComercial(String dddTelComercial) {
		this.dddTelComercial = dddTelComercial;
	}

	public String getTelComercial() {
		return telComercial;
	}

	public void setTelComercial(String telComercial) {
		this.telComercial = telComercial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




}
