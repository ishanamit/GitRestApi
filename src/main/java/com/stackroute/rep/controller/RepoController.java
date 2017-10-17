package com.stackroute.rep.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.rep.model.Repos;
import com.stackroute.rep.service.RepoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
public class RepoController {
    @Autowired
     RepoService repoService;
    
    @GetMapping("/repos")
    public ResponseEntity<?> getAllSavedRepos() {
    	try
        {
        
        return new  ResponseEntity<List<Repos>>(repoService.getAllRepos(), HttpStatus.OK);
        }  
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<String>("No Content Found",HttpStatus.CONFLICT);
         }
    }   
    @GetMapping("/repos/{id}")
    public ResponseEntity<?> getRepo(@PathVariable(value="id") String id) {
    	try
        {
        
        return new  ResponseEntity<Repos>(repoService.getRepos(id), HttpStatus.OK);
        }  
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<String>("No Content Found",HttpStatus.CONFLICT);
         }  
        

    }   
    @PostMapping("/repos") 
    public ResponseEntity<String> addRepo(@RequestBody Repos repo) {
    	try
        {
          repoService.addRepos(repo);
        return new  ResponseEntity("repo successfully added", HttpStatus.OK);
        }  
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<String>("Repo already exists!",HttpStatus.CONFLICT);
         }  
    }
    @PutMapping("/repos/{id}")
    public ResponseEntity<String> updateRepos(@RequestBody Repos repo, @PathVariable(value= "id") String id) {
    	try
    	{
    		 repoService.updateRepos(id,repo);
    		 return new  ResponseEntity("repo successfully updated", HttpStatus.OK);
    	}
    	catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<String>("Repo does not exist!",HttpStatus.CONFLICT);
         } 
    }
    
    @DeleteMapping("/repos/{id}")
    public ResponseEntity<String> deleteRepos(@PathVariable(value="id") String id,@RequestBody Repos repo) {
    	try
    	{
    	repoService.deleteRepos(id);
    	return new  ResponseEntity("repo successfully deleted", HttpStatus.OK);
    	
        }
    	catch(Exception e)
    	{
    		 e.printStackTrace();
             return new ResponseEntity<String>("Repo does not exist!",HttpStatus.CONFLICT);
    	}
}
}