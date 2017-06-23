package net.exemple.springbootrestjpaderby.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface MarqueDAO extends CrudRepository<Marque, Integer> {

}
