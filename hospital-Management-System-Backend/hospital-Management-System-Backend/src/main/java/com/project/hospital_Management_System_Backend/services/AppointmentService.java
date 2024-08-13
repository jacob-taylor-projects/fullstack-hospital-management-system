package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.AppointmentsDto;

import java.util.List;

public interface AppointmentService {
    AppointmentsDto createAppointment(Long id, AppointmentsDto appointmentsDto);

    List<AppointmentsDto> getAppointments(Long id);

    AppointmentsDto updateAppointment(Long id, Long appointmentId, AppointmentsDto appointmentsDto);

    void deleteAppointment(Long id, Long appointmentId);
}
