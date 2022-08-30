package com.Topicos.RelogioPonto.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Topicos.RelogioPonto.model.Registro;
import com.Topicos.RelogioPonto.repository.RegistroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

	@RestController
	@RequestMapping("/registros")

	public class RegistroController {
		
		@Autowired
		private RegistroRepository registroRepository;
		
		@GetMapping
		public List<Registro> listar() {
			return registroRepository.findAll();
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Registro adicionar(@RequestBody Registro registro) {
			return registroRepository.save(registro);
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public Optional<Registro> getRegistroById(@PathVariable("id") long id) {
			return registroRepository.findById(id);
		}
		
		@RequestMapping(value="/calculoHoras/{id}", method=RequestMethod.GET)
		public String getHorasTrabalhadasById(@PathVariable("id") long id) {
			Optional<Registro> registro = registroRepository.findById(id);
			
			Calendar inicio = Calendar.getInstance();
			inicio.set(registro.get().getDatahoraInicial().getYear(), 
					registro.get().getDatahoraInicial().getMonthValue(), 
					registro.get().getDatahoraInicial().getDayOfMonth(),
					registro.get().getDatahoraInicial().getHour(), 
					registro.get().getDatahoraInicial().getMinute()
					);
			
			Calendar fim = Calendar.getInstance();
			fim.set(registro.get().getDatahoraFinal().getYear(), 
					registro.get().getDatahoraFinal().getMonthValue(), 
					registro.get().getDatahoraFinal().getDayOfMonth(),
					registro.get().getDatahoraFinal().getHour(), 
					registro.get().getDatahoraFinal().getMinute());
			
			inicio.set(Calendar.MILLISECOND, 0);
			fim.set(Calendar.MILLISECOND, 0);
			
			java.util.Date ini = inicio.getTime();
			java.util.Date fi = fim.getTime();
			
			long timestamp = fi.getTime() - ini.getTime();
			
			long qtdDias = TimeUnit.MILLISECONDS.toHours(timestamp);
			
			System.out.println(qtdDias);
			
			return "Horas trabalhadas pelo funcionário: " + qtdDias;
		}
		
	
}
