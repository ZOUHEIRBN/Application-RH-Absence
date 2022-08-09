package com.pepsi.rh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import com.pepsi.rh.entities.Collaborator;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "collaborateur")
public interface ICollaborateur  extends JpaRepository<Collaborator, Long>{
    public List<Collaborator> findByCin(String cin);
    public List<Collaborator> findByCinAndActived(String cin, boolean actived);
}
