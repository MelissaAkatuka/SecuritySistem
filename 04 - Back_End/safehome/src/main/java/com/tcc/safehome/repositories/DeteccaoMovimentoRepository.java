package com.tcc.safehome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tcc.safehome.domain.DeteccaoMovimento;

@Repository
public interface DeteccaoMovimentoRepository extends JpaRepository<DeteccaoMovimento, Integer>{

}
