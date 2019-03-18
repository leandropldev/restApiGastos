package com.controleGastos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleGastos.model.Gastos;

public interface GastosRepository extends JpaRepository<Gastos, Integer>{
	
	List<Gastos> findByData(String data);
	Gastos findById(Integer id);
}
