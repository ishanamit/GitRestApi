package com.stackroute.rep.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.rep.model.Repos;
import com.stackroute.rep.repository.RepoRepository;



@Service
public class RepoService {
	@Autowired
	 RepoRepository repoRepository;
    List<Repos> repos = new ArrayList<>(Arrays.asList(
//            new Repos("R1","ishan","java"),
//            new Repos("R2","agni","spring"),
//            new Repos("R3","agniswar","bootstrap")          
            ));
    
    public List<Repos> getAllRepos() {
    	List<Repos> repos=new ArrayList();
    	repoRepository.findAll().forEach(repos::add);
        return repos;
    }
    
    public Repos getRepos(String id) throws Exception {
    	Repos repo = repoRepository.findOne(id);
		if(repo==null)
			throw new Exception();
		else
		 return repoRepository.findOne(id);
    }
    
    public void addRepos(Repos repo) throws Exception {
    	Repos repo1=repoRepository.findOne(repo.getId());
    	if(repo1==null)
			repoRepository.save(repo1);
		else
			throw new Exception();
    	
    	}
    	
    public void updateRepos( String id,Repos repo) throws Exception {
    	Repos repo2=repoRepository.findOne(id);
    	if(repo2==null)
			throw new Exception();
		else
		  repoRepository.save(repo2);
        
    }
    public void deleteRepos(String id) throws Exception {
    	Repos repo3=repoRepository.findOne(id);
    	if(repo3==null)
			throw new Exception();
		else
		  repoRepository.delete(repo3);
    	
}

	public void setProductRepository(RepoRepository productRepository) {
		// TODO Auto-generated method stub
		
	}

	public Repos getProductById(String i) {
		// TODO Auto-generated method stub
		return repoRepository.findOne(i);
	}

	public Repos saveProduct(Repos repo) {
		// TODO Auto-generated method stub
		return repoRepository.save(repo) ;
	}
}