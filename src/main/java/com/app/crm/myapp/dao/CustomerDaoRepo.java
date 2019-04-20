package com.app.crm.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.crm.myapp.entity.Customer;

public interface CustomerDaoRepo extends JpaRepository<Customer, Integer> {

}
