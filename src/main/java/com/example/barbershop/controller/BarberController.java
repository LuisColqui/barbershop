package com.example.barbershop.controller;

import java.util.List;
import java.util.Arrays;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.example.barbershop.model.Barber;
import com.example.barbershop.dto.GenericResponse;
import com.example.barbershop.service.IBarberService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequiredArgsConstructor
@RequestMapping("/barbers")
public class BarberController {

    private final IBarberService service;

    @GetMapping
    public ResponseEntity<GenericResponse<Barber>> findAll() {
        List<Barber> list = service.findAll();
        return ResponseEntity.ok(new GenericResponse<>(200, "Success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<Barber>> findById(@PathVariable Integer id) {
        Barber obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "Success", Arrays.asList((obj))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Barber barber) {
        Barber obj = service.save(barber);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdBarber()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<Barber>> update(@Valid @RequestBody Barber barber, @PathVariable Integer id) {
        barber.setIdBarber(id);
        Barber obj = service.update(id, barber);
        return ResponseEntity.ok(new GenericResponse<>(200, "Barber updated successfully", Arrays.asList(obj)));
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}   
