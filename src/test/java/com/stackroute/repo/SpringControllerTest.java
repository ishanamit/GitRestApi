package com.stackroute.repo;




import static org.junit.Assert.*;

import org.apache.catalina.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.rep.model.Repos;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Repo.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringControllerTest {
    String user1;
//    @LocalServerPort
//    private int port;
    ConfigurableApplicationContext context;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    Repos repo;
    @Before
    public void setUp() throws Exception {
         repo = new Repos("59e1e7abe316310c8f05190d","updated javaaa","uupdated11 isha");
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:8080/repos/"+uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testUpdateRepo() throws Exception {
        HttpEntity<Repos> entity = new HttpEntity<Repos>(repo);
       /* ResponseEntity<String> response = restTemplate.exchange(
        		"http://localhost:8080/repos/R4",
                HttpMethod.PUT, entity, String.class);*/
        ResponseEntity<String> response = restTemplate.exchange(
        		createURLWithPort("59e1e7abe316310c8f05190d"),
                HttpMethod.PUT, entity, String.class);
        
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("repo successfully updated",actual);
    }
    @Test
    public void testDeleteRepo() throws Exception {
        HttpEntity<Repos> entity = new HttpEntity<Repos>(repo);
       /* ResponseEntity<String> response = restTemplate.exchange(
        		"http://localhost:8080/repos/R4",
                HttpMethod.PUT, entity, String.class);*/
        ResponseEntity<String> response = restTemplate.exchange(
        		createURLWithPort("59e1e7abe316310c8f05190d"),
                HttpMethod.DELETE, entity, String.class);
        
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("repo successfully deleted",actual);
    }
    
    
    
    
}

