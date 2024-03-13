package com.example.demo.models;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imc")
public class IMCModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column
    private Double imc;
    
    @Column
	    private Double altura;
	
    @Column
    private Double peso;
	
    @Column
	private Long user_id;
    
    @Column
   	private ZonedDateTime time;
    
    @Column
    private String username;
    
   




	public ZonedDateTime getTime() {
		return time;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setTime(ZonedDateTime time) {
		this.time = time;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getImc() {
		imc = peso / (Math.pow(altura, 2));
		return imc;
	}


	public void setImc(Double imc) {
		this.imc = imc;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}









	
	
	
	
	
	
	
}
