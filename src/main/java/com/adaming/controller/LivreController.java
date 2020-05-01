package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.model.Livre;
import com.adaming.service.LivreService;

@RestController
@CrossOrigin
@RequestMapping("/livre")
public class LivreController {
	
	
	@Autowired
	LivreService livreSer;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Livre> findALL()
	{
		return livreSer.getAll();
	}
	
	
	@RequestMapping(value="/getAllByUser/{nom}",method=RequestMethod.GET)
	public List<Livre> getAllByUser(@PathVariable("nom") String login)
	{
		return livreSer.getAllByUser(login);
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void addUser(@RequestBody Livre l) 
	{
		livreSer.saveOrUpdate(l);
	}
	@PreAuthorize("hasROLE('ROLE_ADMIN')")
	@RequestMapping(value="/remove/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) 
	{
		livreSer.deleteById(id);
	}
	
	@RequestMapping(value="/reserver/{nom}",method=RequestMethod.POST)
	public void reserver(@PathVariable("nom") String login, @RequestBody Livre l)
	{
		 livreSer.reserver(l,login);
	}
	
	@RequestMapping(value="/Annuler_reservation/{nom}",method=RequestMethod.POST)
	public void Annuler_reservation(@PathVariable("nom") String login, @RequestBody Livre l)
	{
		 livreSer.Annuler_reservation(l,login);
	}

}
