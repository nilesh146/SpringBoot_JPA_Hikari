package com.ace.Repository;

import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ace.dto.entity.Person;

@Repository
public interface PersonRepository  extends CrudRepository<Person, Long>   {
	//e.g of @Query for Retrive Operation
	@Query(value="SELECT * FROM person",nativeQuery = true)
	public List<Person> getAllPerson();
	
	//e.g of @NamedQuery update Operation
	@Modifying
	@Transactional
	public void  updateMobile(  @Param("person_id")int  personId, @Param("mobile") String mobile);

}
