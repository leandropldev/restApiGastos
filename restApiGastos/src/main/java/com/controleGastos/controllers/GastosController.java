package com.controleGastos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.controleGastos.model.Gastos;
import com.controleGastos.repository.GastosRepository;

@RestController
public class GastosController {
	
	private static final Logger logger = LoggerFactory.getLogger(GastosController.class);

	@Autowired
	private GastosRepository gastosRepository;
	
	@RequestMapping(method=RequestMethod.POST, value="/registraGastos")
	public @ResponseBody Gastos registraGastos(@RequestBody Gastos gasto) {
		
		logger.info(gasto.toString());
		
		//Funcionalidade Eletiva: Categorização automatica de gasto
		List<Gastos> todosGastos = gastosRepository.findAll();
		todosGastos.stream()
			.filter(gastos -> gasto.getDescricao().equals(gastos.getDescricao()))
			.forEach(gastos -> gasto.setCategoria(gastos.getCategoria()));
		
		gastosRepository.save(gasto);
		return gasto;
	}
	
	@GetMapping(path="/allGastos")
	public @ResponseBody Iterable<Gastos> allGastos() {
		return gastosRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/informaGastosData{data}")
	public @ResponseBody List<Gastos> informaGastosData(@RequestParam("data") String data){
		return gastosRepository.findByData(data);
	}
	
	@RequestMapping(value = "/categorizaGasto", method=RequestMethod.GET)
	public @ResponseBody String categorizaGasto(@RequestParam ("id") Integer id, @RequestParam ("categoria") String categoria){
		
		Gastos gasto = gastosRepository.findById(id);
		//Gastos gasto = gastos.orElse(null);
		
		if(gasto == null) {
			return "Nenhum gasto com o id [" + id + "] foi localizado!";
		}else {
			if(gasto.getCategoria().equals("")) {
				gasto.setCategoria(categoria);
				gastosRepository.save(gasto);
				return "Categoria atualizada com sucesso! [" + categoria + "]";
			}else {
				return "O id [" + id + "] já possui categoria informada!";
			}
		}
	}
	
	@GetMapping(path="/retornaCategorias")
	public @ResponseBody List<String> retornaCategorias() {
		
		List<Gastos> todosGastos = gastosRepository.findAll();
		List<String> listaCategorias = new ArrayList<String>();
			
		todosGastos.stream()
			.filter(gasto -> !gasto.getCategoria().equals(""))
			.forEach(gasto -> listaCategorias.add(gasto.getCategoria()));
			
		return listaCategorias;
	}
}
