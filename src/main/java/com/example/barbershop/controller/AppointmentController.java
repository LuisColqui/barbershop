package com.example.barbershop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;

import com.example.barbershop.model.Appointment;
import com.example.barbershop.dto.GenericResponse;
import com.example.barbershop.service.IAppointmentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;
import java.util.Arrays;
import java.net.URI;
@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

    private final IAppointmentService service;

    @GetMapping
    public ResponseEntity<GenericResponse<Appointment>> findAll() {
        return ResponseEntity.ok(new GenericResponse<>(200, "Success", service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<Appointment>> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(new GenericResponse<>(200, "Success", Arrays.asList(service.findById(id))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Appointment appointment) {
        Appointment obj = service.save(appointment);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAppointment()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<Appointment>> update(@Valid @RequestBody Appointment appointment, @PathVariable Integer id) {
        appointment.setIdAppointment(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "Success", Arrays.asList(service.update(id, appointment))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

