package com.jpss.APIHerois.repository;

import com.jpss.APIHerois.document.Heroi;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface RepositorioHeroi extends CrudRepository<Heroi, String>{

}
