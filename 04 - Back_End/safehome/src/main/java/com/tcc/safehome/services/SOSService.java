package com.tcc.safehome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tcc.safehome.domain.SOS;
import com.tcc.safehome.repositories.SOSRepository;
import com.tcc.safehome.services.exceptions.DataIntegrityException;
import com.tcc.safehome.services.exceptions.ObjectNotFoundException;

@Service
public class SOSService {
	@Autowired
	private SOSRepository sosRepository;
	
	public SOS find(Integer id) {
		Optional<SOS> obj = sosRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + SOS.class.getName()));
	}
	
	public SOS insert(SOS obj) {
		obj.setId(null);
		return sosRepository.save(obj);
	}
	
	public SOS update(SOS obj) {
		find(obj.getId());
		return sosRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			sosRepository.deleteById(id);
			
		} catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir um usuário que possui casa");
			
		}
	}
	
	public List<SOS> findAll(){
		return sosRepository.findAll();
	}
	
	public Page<SOS> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return sosRepository.findAll(pageRequest);
	}
}
