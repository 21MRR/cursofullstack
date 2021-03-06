package com.educandoweb.cursofullstack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.cursofullstack.domain.Categoria;
import com.educandoweb.cursofullstack.repositories.CategoriaRepository;
import com.educandoweb.cursofullstack.services.exception.DataIntregryException;
import com.educandoweb.cursofullstack.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {

		return repo.findAll();
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	public Categoria update(Categoria obj) {
		buscar(obj.getId());
		return repo.save(obj);

	}

	public void delete(Integer id) {
		buscar(id);

		try {
			repo.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntregryException("Não é possivel excluir uma categoria que possui produtos !!");
		}

	}

}
