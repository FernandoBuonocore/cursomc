package com.buonotec.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buonotec.cursomc.domain.Categoria;
import com.buonotec.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaDao;
	
	public Categoria buscarCategoria(Integer id) {
		Optional<Categoria> opt = categoriaDao.findById(id);
		return opt.orElse(null);
	}
	
}
