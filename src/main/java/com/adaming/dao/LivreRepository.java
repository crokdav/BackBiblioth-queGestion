package com.adaming.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adaming.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long>{

}
