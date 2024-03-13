package com.example.demo.dto;

import java.time.ZonedDateTime;

public class IMCDTO {
	
    private Long id;
    private Double imc;
    private Double altura;
    private Double peso;
	private Long user_id;
	private String username;
   	private ZonedDateTime time;


	
	
	
	public ZonedDateTime getTime() {
		return time;
	}
	public void setTime(ZonedDateTime time) {
		this.time = time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
