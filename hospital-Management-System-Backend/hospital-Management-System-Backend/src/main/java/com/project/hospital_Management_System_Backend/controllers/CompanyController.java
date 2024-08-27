package com.project.hospital_Management_System_Backend.controllers;

import com.project.hospital_Management_System_Backend.dtos.*;
import com.project.hospital_Management_System_Backend.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CompanyController {
    private final CompanyService companyService;
    private final AnnouncementService announcementService;
    private final EmployeeService employeeService;
    private final PatientService patientService;
    private final PrescriptionsService prescriptionsService;
    private final ProceduresService proceduresService;
    private final AppointmentService appointmentService;

    //Companies
    @GetMapping("/all-employees")
    public Set<CompanyDto> getAllEmployeesCompanies(@RequestBody CredentialsDto credentialDto) {
        return companyService.getAllEmployeesCompanies(credentialDto);
    }

    @GetMapping("/all-patients")
    public Set<CompanyDto> getAllPatientsCompanies(@RequestBody CredentialsDto credentialDto) {
        return companyService.getAllPatientsCompanies(credentialDto);
    }

    //Announcements
    @PostMapping("/{id}/announcement")
    @ResponseStatus(HttpStatus.CREATED)
    public AnnouncementsDto postAnnouncement(@PathVariable Long id, @RequestBody AnnouncementsDto announcementsDto) {
        return announcementService.postAnnouncement(id, announcementsDto);
    }

    @GetMapping("/{id}/announcements")
    public List<AnnouncementsDto> getAnnouncements(@PathVariable Long id) {
        return announcementService.getAnnouncements(id);
    }
    

    @PutMapping("/{id}/announcement/{announcementId}")
    public AnnouncementsDto updateAnnouncement(@PathVariable Long id, @PathVariable Long announcementId, @RequestBody AnnouncementsDto announcementsDto) {
        return announcementService.updateAnnouncement(id, announcementId, announcementsDto);
    }

    @DeleteMapping("/{id}/announcement/{announcementId}")
    public void deleteAnnouncement(@PathVariable Long id, @PathVariable Long announcementId) {
        announcementService.deleteAnnouncement(id, announcementId);
    }

    //Employees
    @PostMapping("/{id}/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public FullEmployeeDto createEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDto employeeRequestDto) {
       return employeeService.createEmployee(id, employeeRequestDto);
    }

    @GetMapping("/{id}/employees")
    public Set<FullEmployeeDto> getEmployees(@PathVariable Long id){
        return employeeService.getEmployees(id);
    }

    @GetMapping("/{id}/employee/{employeeId}/patients")
    public Set<BasicPatientDto> getEmployeesPatients(@PathVariable Long id,@PathVariable Long employeeId){
        return employeeService.getEmployeesPatients(id,employeeId);
    }

    @GetMapping("/{id}/employee/{employeeId}/appointments")
    public List<AppointmentsDto> getEmployeesAppointments(@PathVariable Long id,@PathVariable Long employeeId){
        return employeeService.getEmployeesAppointments(id,employeeId);
    }

    @GetMapping("/{id}/employee/{employeeId}/prescriptions")
    public List<PrescriptionsDto> getEmployeesPrescriptions(@PathVariable Long id,@PathVariable Long employeeId){
        return employeeService.getEmployeesPrescriptions(id,employeeId);
    }

    @GetMapping("/{id}/employee/{employeeId}/procedures")
    public List<ProceduresDto> getEmployeesProcedures(@PathVariable Long id,@PathVariable Long employeeId){
        return employeeService.getEmployeesProcedures(id,employeeId);
    }

    @GetMapping("/{id}/employee/{employeeId}")
    public FullEmployeeDto getEmployee(@PathVariable Long id,@PathVariable Long employeeId){
        return employeeService.getEmployee(id,employeeId);
    }

    @PutMapping("/{id}/employee/{employeeId}")
    public BasicEmployeeDto updateEmployee(@PathVariable Long id, @PathVariable Long employeeId, @RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.updateEmployee(id,employeeId,employeeRequestDto);
    }

    @DeleteMapping("/{id}/employee/{employeeId}")
    public void deleteEmployee(@PathVariable Long id, @PathVariable Long employeeId){
        employeeService.deleteEmployee(id,employeeId);
    }

    //Patients
    @PostMapping("/{id}/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public FullPatientDto createPatient(@PathVariable Long id, @RequestBody PatientRequestDto patientRequestDto) {
        return patientService.createPatient(id,patientRequestDto);
    }
    @GetMapping("/{id}/patients")
    public Set<FullPatientDto> getPatients(@PathVariable Long id){
        return patientService.getPatients(id);
    }

    @GetMapping("/{id}/patient/{patientId}/appointments")
    public List<AppointmentsDto> getPatientsAppointments(@PathVariable Long id,@PathVariable Long patientId){
        return patientService.getPatientsAppointments(id,patientId);
    }

    @GetMapping("/{id}/patient/{patientId}/prescriptions")
    public List<PrescriptionsDto> getPatientsPrescriptions(@PathVariable Long id,@PathVariable Long patientId){
        return patientService.getPatientsPrescriptions(id,patientId);
    }

    @GetMapping("/{id}/patient/{patientId}/procedures")
    public List<ProceduresDto> getPatientsProcedures(@PathVariable Long id,@PathVariable Long patientId){
        return patientService.getPatientsProcedures(id,patientId);
    }
    @GetMapping("/{id}/patient/{patientId}/doctors")
    public Set<BasicEmployeeDto> getPatientsDoctors(@PathVariable Long id,@PathVariable Long patientId){
        return patientService.getPatientsDoctors(id,patientId);
    }

    @GetMapping("/{id}/patient/{patientId}")
    public FullPatientDto getPatient(@PathVariable Long id,@PathVariable Long patientId){
        return patientService.getPatient(id,patientId);
    }

    @PutMapping("/{id}/patient/{patientId}")
    public BasicPatientDto updatePatient(@PathVariable Long id, @PathVariable Long patientId, @RequestBody PatientRequestDto patientRequestDto) {
        return patientService.updatePatient(id,patientId,patientRequestDto);
    }
    @DeleteMapping("/{id}/patient/{patientId}")
    public void deletePatient(@PathVariable Long id, @PathVariable Long patientId){
        patientService.deletePatient(id,patientId);
    }

    //Prescriptions
    @PostMapping("/{id}/prescription")
    @ResponseStatus(HttpStatus.CREATED)
    public PrescriptionsDto createPrescription(@PathVariable Long id, @RequestBody PrescriptionsDto prescriptionsDto) {
        return prescriptionsService.createPrescription(id,prescriptionsDto);
    }

    @GetMapping("/{id}/prescriptions")
    public List<PrescriptionsDto> getPrescriptions(@PathVariable Long id) {
        return prescriptionsService.getPrescriptions(id);
    }

    @PutMapping("/{id}/prescription/{prescriptionId}")
    public PrescriptionsDto updatePrescription(@PathVariable Long id,@PathVariable Long prescriptionId,@RequestBody PrescriptionsDto prescriptionsDto){
        return prescriptionsService.updatePrescription(id,prescriptionId,prescriptionsDto);
    }

    @DeleteMapping("/{id}/prescription/{prescriptionId}")
    public void deletePrescription(@PathVariable Long id,@PathVariable Long prescriptionId){
        prescriptionsService.deletePrescription(id,prescriptionId);
    }

    //Procedures
    @PostMapping("/{id}/procedure")
    @ResponseStatus(HttpStatus.CREATED)
    public ProceduresDto createProcedure(@PathVariable Long id, @RequestBody ProceduresDto proceduresDto) {
        return proceduresService.createProcedure(id,proceduresDto);
    }

    @GetMapping("/{id}/procedures")
    public List<ProceduresDto> getProcedures(@PathVariable Long id) {
        return proceduresService.getProcedures(id);
    }

    @PutMapping("/{id}/procedure/{procedureId}")
    public ProceduresDto updateProcedure(@PathVariable Long id,@PathVariable Long procedureId,@RequestBody ProceduresDto proceduresDto){
        return proceduresService.updateProcedure(id,procedureId,proceduresDto);
    }

    @DeleteMapping("/{id}/procedure/{procedureId}")
    public void deleteProcedure(@PathVariable Long id,@PathVariable Long procedureId){
        proceduresService.deleteProcedure(id,procedureId);
    }

    //Appointments
    @PostMapping("/{id}/appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentsDto createAppointment(@PathVariable Long id, @RequestBody AppointmentsDto appointmentsDto) {
        return appointmentService.createAppointment(id,appointmentsDto);
    }

    @GetMapping("/{id}/appointments")
    public List<AppointmentsDto> getAppointments(@PathVariable Long id){
        return appointmentService.getAppointments(id);
    }

    @PutMapping("/{id}/appointment/{appointmentId}")
    public AppointmentsDto updateAppointment(@PathVariable Long id,@PathVariable Long appointmentId,@RequestBody AppointmentsDto appointmentsDto){
        return appointmentService.updateAppointment(id,appointmentId,appointmentsDto);
    }

    @DeleteMapping("/{id}/appointment/{appointmentId}")
    public void deleteAppointment(@PathVariable Long id,@PathVariable Long appointmentId){
        appointmentService.deleteAppointment(id,appointmentId);
    }
}
