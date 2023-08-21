package com.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Service;
import com.app.entity.Vendor;
import com.app.enums.Category;

public interface ServiceRepositoryIF extends JpaRepository<Service, Long>{

	public List<Service> findByVendor(Vendor vendor);
	
	public ArrayList<Service> findByCategory(Category category);

}
