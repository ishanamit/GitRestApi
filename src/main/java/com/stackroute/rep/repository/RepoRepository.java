package com.stackroute.rep.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.rep.model.Repos;

@Repository
public interface RepoRepository extends CrudRepository<Repos,String> {

}
