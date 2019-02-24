package com.amir.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_pedido; 
	private String estado;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@JsonIgnore
	@OneToMany(mappedBy="pedido",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Pedido_Detalle> pedidos_detalles;
	
	@PrePersist
	public void prePersist() {
		this.fecha_pedido=new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pedido_Detalle> getPedidos_detalles() {
		return pedidos_detalles;
	}

	public void setPedidos_detalles(List<Pedido_Detalle> pedidos_detalles) {
		this.pedidos_detalles = pedidos_detalles;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha_pedido=" + fecha_pedido + ", estado=" + estado + ", cliente=" + cliente
				+ ", pedidos_detalles=" + pedidos_detalles + "]";
	}

}
