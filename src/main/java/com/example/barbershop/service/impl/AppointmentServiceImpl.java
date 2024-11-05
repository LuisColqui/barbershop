package com.example.barbershop.service.impl;

import com.example.barbershop.model.Appointment;
import com.example.barbershop.repo.IGenericRepo;
import com.example.barbershop.repo.IAppointmentRepo;
import com.example.barbershop.service.IAppointmentService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl extends CRUDImpl<Appointment, Integer> implements IAppointmentService {

    private final IAppointmentRepo repo;

    @Override
    protected IGenericRepo<Appointment, Integer> getRepo() {
        return repo;
    }
}
