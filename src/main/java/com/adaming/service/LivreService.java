package com.adaming.service;

import java.util.List;

import com.adaming.model.Livre;

public interface LivreService {
	
	public List<Livre> getAll();
	public void deleteById(int id);
	public Livre saveOrUpdate(Livre l);
	public List<Livre> getAllByUser(String login);
	public void reserver(Livre l, String login);
	public void Annuler_reservation(Livre l, String login);


}
