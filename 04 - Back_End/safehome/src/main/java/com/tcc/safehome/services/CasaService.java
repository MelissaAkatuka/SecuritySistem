package com.tcc.safehome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tcc.safehome.domain.Casa;
import com.tcc.safehome.repositories.CasaRepository;
import com.tcc.safehome.services.exceptions.DataIntegrityException;
import com.tcc.safehome.services.exceptions.ObjectNotFoundException;

@Service
public class CasaService {
	@Autowired
	private CasaRepository casaRepository;
	
	public Casa find(Integer id) {
		Optional<Casa> obj = casaRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Casa.class.getName()));
	}
	
	public Casa insert(Casa obj) {
		obj.setId(null);
		return casaRepository.save(obj);
	}
	
	public Casa update(Casa obj) {
		find(obj.getId());
		return casaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			casaRepository.deleteById(id);
			
		} catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir um usuário que possui casa");
			
		}
	}
	
	public List<Casa> findAll(){
		return casaRepository.findAll();
	}
	
	public Page<Casa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return casaRepository.findAll(pageRequest);
	}

}
