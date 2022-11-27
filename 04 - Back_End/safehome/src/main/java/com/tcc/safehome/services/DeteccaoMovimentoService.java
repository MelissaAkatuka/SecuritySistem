package com.tcc.safehome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tcc.safehome.domain.DeteccaoMovimento;
import com.tcc.safehome.repositories.DeteccaoMovimentoRepository;
import com.tcc.safehome.services.exceptions.DataIntegrityException;
import com.tcc.safehome.services.exceptions.ObjectNotFoundException;

@Service
public class DeteccaoMovimentoService {
	@Autowired
	private DeteccaoMovimentoRepository deteccaoMovimentoRepository;
	
	public DeteccaoMovimento find(Integer id) {
		Optional<DeteccaoMovimento> obj = deteccaoMovimentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + DeteccaoMovimento.class.getName()));
	}
	
	public DeteccaoMovimento insert(DeteccaoMovimento obj) {
		obj.setId(null);
		return deteccaoMovimentoRepository.save(obj);
	}
	
	public DeteccaoMovimento update(DeteccaoMovimento obj) {
		find(obj.getId());
		return deteccaoMovimentoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			deteccaoMovimentoRepository.deleteById(id);
			
		} catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir um usuário que possui casa");
			
		}
	}
	
	public List<DeteccaoMovimento> findAll(){
		return deteccaoMovimentoRepository.findAll();
	}
	
	public Page<DeteccaoMovimento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return deteccaoMovimentoRepository.findAll(pageRequest);
	}
}
