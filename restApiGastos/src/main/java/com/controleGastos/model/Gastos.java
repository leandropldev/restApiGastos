package com.controleGastos.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "gastos")
public class Gastos {

	/*"descricao": "alfanumerico", "valor": double americano, "codigousuario": numerico,
	"data": Data dem formato UTC*/
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String descricao;
	private Double valor;
	private Integer codigousuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy")//, timezone = TimeZone.getDefault(), locale = Locale.getDefault())
	private String data;
	private String categoria = "";
	
	protected Gastos() {}
	
	public Gastos(String descricao, Double valor, Integer codigousuario, String data, String categoria) {
		this.descricao = descricao;
		this.valor = valor;
		this.codigousuario = codigousuario;
		this.data = data;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getCodigousuario() {
		return codigousuario;
	}
	public void setCodigousuario(int codigousuario) {
		this.codigousuario = codigousuario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Gastos [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", codigousuario=" + codigousuario
				+ ", data=" + data + ", categoria=" + categoria + "]";
	}
	
	
}
