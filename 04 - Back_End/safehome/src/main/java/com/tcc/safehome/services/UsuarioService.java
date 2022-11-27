package com.tcc.safehome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tcc.safehome.domain.Usuario;
import com.tcc.safehome.repositories.UsuarioRepository;
import com.tcc.safehome.services.exceptions.DataIntegrityException;
import com.tcc.safehome.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return usuarioRepository.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		find(obj.getId());
		return usuarioRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			usuarioRepository.deleteById(id);
			
		} catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir um usuário que possui casa");
			
		}
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return usuarioRepository.findAll(pageRequest);
	}
}
