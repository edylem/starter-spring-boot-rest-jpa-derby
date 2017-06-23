package net.exemple.springbootrestjpaderby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.exemple.springbootrestjpaderby.model.Marque;
import net.exemple.springbootrestjpaderby.model.MarqueDAO;
import net.exemple.springbootrestjpaderby.model.Voiture;
import net.exemple.springbootrestjpaderby.model.VoitureDAO;

@RestController
@RequestMapping("voiture/")
public class VoitureController {

    @Autowired
    private VoitureDAO voitureDao;

    @Autowired
    private MarqueDAO marqueDao;

    /**
     * URL : http://localhost:8080/voiture/find/all
     * 
     * @return
     */
    @RequestMapping("find/all")
    public Iterable<Voiture> getList() {
        return voitureDao.findAll();
    }

    /**
     * URLs :<br>
     * http://localhost:8080/voiture/add/ax/citroen<br>
     * http://localhost:8080/voiture/add/saxo/citroen<br>
     * http://localhost:8080/voiture/add/206/peugeot<br>
     * http://localhost:8080/voiture/add/3008/peugeot<br>
     * http://localhost:8080/voiture/add/duster/dacia
     * 
     * @param nom
     */
    @RequestMapping("add/{nom}/{marque}")
    public void add(@PathVariable String nom, @PathVariable String marque) {
        Voiture voiture = new Voiture();
        marqueDao.findAll().forEach(o -> {
            if (o.getNom().equals(marque)) {
                voiture.setMarque(o);
            }
        });
        if (voiture.getMarque() == null) {
            Marque marqueObject = new Marque();
            marqueObject.setNom(marque);
            marqueObject = marqueDao.save(marqueObject);
            voiture.setMarque(marqueObject);
        }
        voiture.setNom(nom);
        voitureDao.save(voiture);
    }

}
