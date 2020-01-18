package com.ace.Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ace.dto.entity.Customer;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long>   {
	//e.g of @Query for Retrive Operation
	@Query(value="SELECT * FROM customer_details",nativeQuery = true)
	public List<Customer> getAllPerson();
	
	//e.g of @NamedQuery update Operation
	@Modifying
	@Transactional
	public void  updateMobile(  @Param("cust_id")int  custId, @Param("mobile") String mobile);

	@Modifying
	@Transactional
	public void makeRecordExpire(@Param("expire_date") Date expireDate,@Param("expire_code") char expireCode,@Param("user_id")int  user_id);
	
	public List<Customer> findByuserId( @Param("user_id")int  userId);
}
