package net.exemple.springbootrestjpaderby.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface VoitureDAO extends CrudRepository<Voiture, Integer> {

}
