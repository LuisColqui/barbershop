package com.example.barbershop.service.impl;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import com.example.barbershop.model.Barber;
import com.example.barbershop.repo.IGenericRepo;
import com.example.barbershop.repo.IBarberRepo;
import com.example.barbershop.service.IBarberService;

@Service
@AllArgsConstructor
public class BarberServiceImpl extends CRUDImpl<Barber, Integer> implements IBarberService {

    private final IBarberRepo repo;

    @Override
    protected IGenericRepo<Barber, Integer> getRepo() {
        return repo;
    }

}
