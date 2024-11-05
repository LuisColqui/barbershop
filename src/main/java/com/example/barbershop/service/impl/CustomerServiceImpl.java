package com.example.barbershop.service.impl;



import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


import com.example.barbershop.model.Customer;
import com.example.barbershop.repo.ICustomerRepo;
import com.example.barbershop.repo.IGenericRepo;
import com.example.barbershop.service.ICustomerService;

@Service
@AllArgsConstructor
public class CustomerServiceImpl extends CRUDImpl<Customer, Integer> implements ICustomerService {

    private final ICustomerRepo repo;

    @Override
    protected IGenericRepo<Customer, Integer> getRepo() {
        return repo;
    }

    

}
