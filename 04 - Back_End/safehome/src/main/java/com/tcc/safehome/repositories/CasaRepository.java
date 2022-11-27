package com.tcc.safehome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.safehome.domain.Casa;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Integer>{

}
