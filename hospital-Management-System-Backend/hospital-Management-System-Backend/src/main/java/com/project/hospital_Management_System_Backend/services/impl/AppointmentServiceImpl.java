package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.dtos.AppointmentsDto;
import com.project.hospital_Management_System_Backend.entities.*;
import com.project.hospital_Management_System_Backend.mappers.AppointmentsMapper;
import com.project.hospital_Management_System_Backend.repos.AppointmentsRepo;
import com.project.hospital_Management_System_Backend.services.AppointmentService;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final ValidateService validateService;
    private final AppointmentsMapper appointmentsMapper;
    private final AppointmentsRepo appointmentsRepo;
    @Override
    public AppointmentsDto createAppointment(Long id, AppointmentsDto appointmentsDto) {
        validateService.findCompany(id);
        Employee employee=validateService.findEmployee(appointmentsDto.getDoctor().getId());
        Patient patient=validateService.findPatient(appointmentsDto.getPatient().getId());
        Appointments appointment = appointmentsMapper.dtoToEntity(appointmentsDto);
        appointment.setDate(appointmentsDto.getDate());
        appointment.setStartTime(appointmentsDto.getStartTime());
        appointment.setEndTime(appointmentsDto.getEndTime());
        appointment.setDoctor(employee);
        appointment.setPatient(patient);
        Appointments savedAppointment= appointmentsRepo.saveAndFlush(appointment);
        return appointmentsMapper.entityToDto(savedAppointment);
    }

    @Override
    public List<AppointmentsDto> getAppointments(Long id) {
        Company company = validateService.findCompany(id);
        List<Appointments> appointments = appointmentsRepo.findAll();
        appointments.sort(Comparator.comparing(Appointments::getDate)
                .thenComparing(Appointments::getStartTime));
        return appointmentsMapper.entitiesToDtos(appointments);
    }

    @Override
    public AppointmentsDto updateAppointment(Long id, Long appointmentId, AppointmentsDto appointmentsDto) {
        validateService.findCompany(id);
        Appointments appointments=validateService.findAppointment(appointmentId);
        if (appointmentsDto.getName()!=null){
            appointments.setName(appointmentsDto.getName());
        }
        if (appointmentsDto.getDescription()!=null){
            appointments.setDescription(appointmentsDto.getDescription());
        }
        Employee employee=validateService.findEmployee(appointmentsDto.getDoctor().getId());
        Patient patient=validateService.findPatient(appointmentsDto.getPatient().getId());
        appointments.setDate(appointmentsDto.getDate());
        appointments.setStartTime(appointmentsDto.getStartTime());
        appointments.setEndTime(appointmentsDto.getEndTime());
        appointments.setDoctor(employee);
        appointments.setPatient(patient);
        return appointmentsMapper.entityToDto(appointmentsRepo.saveAndFlush(appointments));
    }

    @Override
    public void deleteAppointment(Long id, Long appointmentId) {
        validateService.findCompany(id);
        appointmentsRepo.deleteById(appointmentId);
    }
}
