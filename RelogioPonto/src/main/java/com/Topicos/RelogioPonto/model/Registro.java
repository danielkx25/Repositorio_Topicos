package com.Topicos.RelogioPonto.model;

import java.util.Objects;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private  LocalDateTime datahoraInicial;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private  LocalDateTime datahoraFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatahoraInicial() {
		return datahoraInicial;
	}

	public void setDatahoraInicial(LocalDateTime datahoraInicial) {
		this.datahoraInicial = datahoraInicial;
	}

	public LocalDateTime getDatahoraFinal() {
		return datahoraFinal;
	}

	public void setDatahoraFinal(LocalDateTime datahoraFinal) {
		this.datahoraFinal = datahoraFinal;
	}

	
	
	
}
