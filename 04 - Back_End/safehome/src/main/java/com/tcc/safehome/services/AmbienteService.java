package com.tcc.safehome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tcc.safehome.domain.Ambiente;
import com.tcc.safehome.repositories.AmbienteRepository;
import com.tcc.safehome.services.exceptions.DataIntegrityException;
import com.tcc.safehome.services.exceptions.ObjectNotFoundException;

@Service
public class AmbienteService {
	@Autowired
	private AmbienteRepository ambienteRepository;
	
	public Ambiente find(Integer id) {
		Optional<Ambiente> obj = ambienteRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Ambiente.class.getName()));
	}
	
	public Ambiente insert(Ambiente obj) {
		obj.setId(null);
		return ambienteRepository.save(obj);
	}
	
	public Ambiente update(Ambiente obj) {
		find(obj.getId());
		return ambienteRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			ambienteRepository.deleteById(id);
			
		} catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir um usuário que possui casa");
			
		}
	}
	
	public List<Ambiente> findAll(){
		return ambienteRepository.findAll();
	}
	
	public Page<Ambiente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return ambienteRepository.findAll(pageRequest);
	}
}
