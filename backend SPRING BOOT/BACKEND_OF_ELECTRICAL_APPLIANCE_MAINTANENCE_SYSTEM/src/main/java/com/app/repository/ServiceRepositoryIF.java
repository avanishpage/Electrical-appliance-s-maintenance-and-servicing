package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Service;
import com.app.entity.Vendor;

public interface ServiceRepositoryIF extends JpaRepository<Service, Long>{

	public List<Service> findByVendor(Vendor vendor);

}
