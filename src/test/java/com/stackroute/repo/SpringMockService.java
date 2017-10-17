package com.stackroute.repo;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.rep.model.Repos;
import com.stackroute.rep.repository.RepoRepository;
import com.stackroute.rep.service.RepoService;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;






public class SpringMockService {

  private RepoService productService;
   @Mock
   private RepoRepository productRepository;
   @Mock
   private Repos repo;
   @Before
   public void setupMock() {
       MockitoAnnotations.initMocks(this);
       productService=new RepoService();
       productService.setProductRepository(productRepository);
   }
   @Test
   public void shouldReturnProduct_whenGetProductByIdIsCalled() throws Exception {
       // Arrange
       when(productRepository.findOne("59e1e7e3e316310c8f05190f")).thenReturn(repo);
     
       // Act
       Repos retrievedProduct = productService.getProductById("59e1e7e3e316310c8f05190f");
       // Assert
       assertThat(retrievedProduct, is(equalTo(repo)));

  }
   @Test
   public void shouldReturnProduct_whenSaveProductIsCalled() throws Exception {
       // Arrange
       when(productRepository.save(repo)).thenReturn(repo);
       // Act
       Repos savedProduct = productService.saveProduct(repo);
       // Assert
       assertThat(savedProduct, is(equalTo(repo)));
   }
   
}