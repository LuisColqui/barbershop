package com.example.barbershop.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAppointment;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "idCustomer", nullable = false, foreignKey = @ForeignKey(name = "FK_APPOINTMENT_CUSTOMER"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "idBarber", nullable = false, foreignKey = @ForeignKey(name = "FK_APPOINTMENT_BARBER"))
    private Barber barber;

    @Column(nullable = false)
    private String haircutType;

    @Column(nullable = false)
    private String status;

}
