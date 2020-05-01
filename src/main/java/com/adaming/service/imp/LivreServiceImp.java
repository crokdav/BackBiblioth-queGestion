package com.adaming.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.LivreRepository;
import com.adaming.dao.NotificationRepository;
import com.adaming.dao.UserRepository;
import com.adaming.model.Livre;
import com.adaming.model.Notification;
import com.adaming.model.UserManager;
import com.adaming.service.LivreService;

@Service
public class LivreServiceImp implements LivreService {

	@Autowired
	LivreRepository livreRep;

	@Autowired
	UserRepository userRep;
	
	@Autowired
	NotificationRepository notRep;

	@Override
	public List<Livre> getAll() {
		return livreRep.findAll();
	}

	@Override
	public void deleteById(int id) {
		livreRep.deleteById((long) id);
	}

	@Override
	public Livre saveOrUpdate(Livre l) {
		return livreRep.save(l);
	}

	@Override
	public List<Livre> getAllByUser(String login) {
		return userRep.findByLogin(login).getMesLivres();
	}

	@Override
	public void reserver(Livre l, String login) {

		UserManager u = userRep.findByLogin(login);
		u.getMesLivres().add(l);
		l.setQuantite(l.getQuantite() - 1);
		livreRep.save(l);
		userRep.save(u);
		Notification n = new Notification(login, new Date(), l);
		notRep.save(n);
	}

	@Override
	public void Annuler_reservation(Livre l, String login) {

		UserManager u = userRep.findByLogin(login);
		int in = 0;
		for (int i = 0; i < u.getMesLivres().size(); i++) {
			if (u.getMesLivres().get(i).equals(l)) {
				in = i;
				break;
			}

		}
		
		u.getMesLivres().remove(in);
		l.setQuantite(l.getQuantite() + 1);
		livreRep.save(l);
		userRep.save(u);

	}

}
