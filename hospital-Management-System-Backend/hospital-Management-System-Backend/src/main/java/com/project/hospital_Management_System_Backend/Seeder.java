package com.project.hospital_Management_System_Backend;

import com.project.hospital_Management_System_Backend.entities.*;
import com.project.hospital_Management_System_Backend.repos.*;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;

@Component
@Data
public class Seeder implements CommandLineRunner {
    private final AnnouncementsRepo announcementRepo;
    private final AppointmentsRepo appointmentsRepo;
    private final CompanyRepo companyRepo;
    private final EmployeeRepo employeeRepo;
    private final PatientRepo patientRepo;
    private final PrescriptionsRepo prescriptionsRepo;
    private final ProceduresRepo proceduresRepo;



    @Override
    public void run(String... args) throws Exception {
        Announcements announcement1 = new Announcements();
        Announcements announcement2 = new Announcements();
        Announcements announcement3 = new Announcements();
        Announcements announcement4 = new Announcements();
        Announcements announcement5 = new Announcements();
        Announcements announcements6=new Announcements();
        Announcements announcements7=new Announcements();
        Announcements announcements8=new Announcements();

        Company company1 = new Company();
        Company company2 = new Company();


        Appointments appointment1=new Appointments();
        Appointments appointment2=new Appointments();
        Appointments appointment3=new Appointments();
        Appointments appointment4=new Appointments();
        Appointments appointment5=new Appointments();
        Appointments appointment6=new Appointments();
        Appointments appointment7=new Appointments();
        Appointments appointment8=new Appointments();

        Prescriptions prescriptions1=new Prescriptions();
        Prescriptions prescriptions2=new Prescriptions();
        Prescriptions prescriptions3=new Prescriptions();
        Prescriptions prescriptions4=new Prescriptions();
        Prescriptions prescriptions5=new Prescriptions();
        Prescriptions prescriptions6=new Prescriptions();
        Prescriptions prescriptions7=new Prescriptions();
        Prescriptions prescriptions8=new Prescriptions();

        Procedures procedures1=new Procedures();
        Procedures procedures2=new Procedures();
        Procedures procedures3=new Procedures();
        Procedures procedures4=new Procedures();
        Procedures procedures5=new Procedures();
        Procedures procedures6=new Procedures();
        Procedures procedures7=new Procedures();
        Procedures procedures8=new Procedures();

        Employee employee1=new Employee();
        Credentials cred1=new Credentials();
        cred1.setUsername("nicholas");
        cred1.setPassword("jones");
        employee1.setCredentials(cred1);
        Profile profile1=new Profile();
        profile1.setFirstName("Nicholas");
        profile1.setLastName("Jones");
        profile1.setEmail("jones@email.com");
        profile1.setPhoneNumber("(111) 111-1111");
        employee1.setProfile(profile1);
        employee1.setAge(31);
        employee1.setGender("male");
        employee1.setAddress("100 street");
        employee1.setAdmin(false);
        employee1.setDoctor(true);
        employee1.setSpecialty("heart doctor");
        employee1.setSalary(100000);

        Employee employee2=new Employee();
        Credentials cred2=new Credentials();
        cred2.setUsername("jacob");
        cred2.setPassword("taylor");
        employee2.setCredentials(cred2);
        Profile profile2=new Profile();
        profile2.setFirstName("Jacob");
        profile2.setLastName("Taylor");
        profile2.setEmail("taylor@email.com");
        profile2.setPhoneNumber("(222) 222-2222");
        employee2.setProfile(profile2);
        employee2.setAge(25);
        employee2.setGender("male");
        employee2.setAddress("200 street");
        employee2.setAdmin(true);
        employee2.setDoctor(true);
        employee2.setSpecialty("head surgeon");
        employee2.setSalary(500000);

        Employee employee3=new Employee();
        Credentials cred3=new Credentials();
        cred3.setUsername("bob");
        cred3.setPassword("tyler");
        employee3.setCredentials(cred3);
        Profile profile3=new Profile();
        profile3.setFirstName("Bob");
        profile3.setLastName("Tyler");
        profile3.setEmail("tyler@email.com");
        profile3.setPhoneNumber("(333) 333-3333");
        employee3.setProfile(profile3);
        employee3.setAge(33);
        employee3.setGender("male");
        employee3.setAddress("300 street");
        employee3.setAdmin(false);
        employee3.setDoctor(false);
        employee3.setSpecialty("nurse");
        employee3.setSalary(50000);

        Employee employee4=new Employee();
        Credentials cred4=new Credentials();
        cred4.setUsername("sarah");
        cred4.setPassword("jones");
        employee4.setCredentials(cred4);
        Profile profile4=new Profile();
        profile4.setFirstName("Sarah");
        profile4.setLastName("Jones");
        profile4.setEmail("jones2@email.com");
        profile4.setPhoneNumber("(444) 444-4444");
        employee4.setProfile(profile4);
        employee4.setAge(41);
        employee4.setGender("female");
        employee4.setAddress("400 street");
        employee4.setAdmin(true);
        employee4.setDoctor(false);
        employee4.setSpecialty("hr specialist");
        employee4.setSalary(90000);

        Patient patient1=new Patient();
        Credentials cred5=new Credentials();
        cred5.setUsername("lisa");
        cred5.setPassword("smith");
        patient1.setCredentials(cred5);
        Profile profile5=new Profile();
        profile5.setFirstName("Lisa");
        profile5.setLastName("Smith");
        profile5.setEmail("smith@email.com");
        profile5.setPhoneNumber("(555) 555-5555");
        patient1.setProfile(profile5);
        patient1.setAge(29);
        patient1.setAddress("1000 blvd");
        patient1.setGender("female");
        patient1.setPrognosis("cancer,stomach flu");

        Patient patient2=new Patient();
        Credentials cred6=new Credentials();
        cred6.setUsername("dakota");
        cred6.setPassword("madison");
        patient2.setCredentials(cred6);
        Profile profile6=new Profile();
        profile6.setFirstName("Dakota");
        profile6.setLastName("Madison");
        profile6.setEmail("madison@email.com");
        profile6.setPhoneNumber("(666) 666-6666");
        patient2.setProfile(profile6);
        patient2.setAge(26);
        patient2.setAddress("2000 blvd");
        patient2.setGender("female");
        patient2.setPrognosis("stomach flu");

        Patient patient3=new Patient();
        Credentials cred7=new Credentials();
        cred7.setUsername("john");
        cred7.setPassword("richards");
        patient3.setCredentials(cred7);
        Profile profile7=new Profile();
        profile7.setFirstName("John");
        profile7.setLastName("Richards");
        profile7.setEmail("richards@email.com");
        profile7.setPhoneNumber("(777) 777-7777");
        patient3.setProfile(profile7);
        patient3.setAge(35);
        patient3.setAddress("3000 blvd");
        patient3.setGender("male");
        patient3.setPrognosis("stomache ache");

        Patient patient4=new Patient();
        Credentials cred8=new Credentials();
        cred8.setUsername("willie");
        cred8.setPassword("nelson");
        patient4.setCredentials(cred8);
        Profile profile8=new Profile();
        profile8.setFirstName("Willie");
        profile8.setLastName("Nelson");
        profile8.setEmail("nelson@email.com");
        profile8.setPhoneNumber("(888) 888-8888");
        patient4.setProfile(profile8);
        patient4.setAge(55);
        patient4.setAddress("4000 blvd");
        patient4.setGender("male");
        patient4.setPrognosis("heart attack");



        announcementRepo.saveAllAndFlush(Arrays.asList(
                announcement1, announcement2, announcement3, announcement4, announcement5,announcements6,announcements7));
        companyRepo.saveAllAndFlush(Arrays.asList(company1, company2));
        appointmentsRepo.saveAllAndFlush(Arrays.asList(appointment1,appointment2,appointment3,appointment4,appointment5,appointment6,appointment7,appointment8));
        employeeRepo.saveAllAndFlush(Arrays.asList(employee1,employee2,employee3,employee4));
        patientRepo.saveAllAndFlush(Arrays.asList(patient1,patient2,patient3,patient4));
        prescriptionsRepo.saveAllAndFlush(Arrays.asList(prescriptions1,prescriptions2,prescriptions3,prescriptions4,prescriptions5,prescriptions6,prescriptions7,prescriptions8));
        proceduresRepo.saveAllAndFlush(Arrays.asList(procedures1,procedures2,procedures3,procedures4,procedures5,procedures6,procedures7,procedures8));

        announcement1.setTitle("Welcome to Spring Hill Doctors");
        announcement1.setMessage("We are gladly accepting new patients");
        announcement1.setCompany(company1);
        announcement1.setAuthor(employee1);

        announcement2.setTitle("Hiring");
        announcement2.setMessage("We are starting hiring for our team");
        announcement2.setCompany(company1);
        announcement2.setAuthor(employee2);

        announcement3.setTitle("New Services");
        announcement3.setMessage("With new doctors, we offer new services!");
        announcement3.setCompany(company1);
        announcement3.setAuthor(employee1);

        announcement4.setTitle("Flu shots");
        announcement4.setMessage("We are glad to be offering free flu shots");
        announcement4.setCompany(company1);
        announcement4.setAuthor(employee2);

        announcement5.setTitle("Welcome to Nashville Doctors");
        announcement5.setMessage("We are gladly accepting new patients");
        announcement5.setCompany(company2);
        announcement5.setAuthor(employee3);

        announcements6.setTitle("Hiring");
        announcements6.setMessage("We are starting hiring for our team");
        announcements6.setCompany(company2);
        announcements6.setAuthor(employee4);

        announcements7.setTitle("New Services");
        announcements7.setMessage("With new doctors, we offer new services!");
        announcements7.setCompany(company2);
        announcements7.setAuthor(employee3);

        announcements8.setTitle("Flu shots");
        announcements8.setMessage("We are offering free flu shots!");
        announcements8.setCompany(company2);
        announcements8.setAuthor(employee4);


        appointment1.setName("Oncology meeting");
        appointment1.setDescription("This is  for cancer treatment");
        appointment1.setDate(LocalDate.of(2023, 3, 15));
        appointment1.setStartTime(LocalTime.of(9, 0));
        appointment1.setEndTime(LocalTime.of(10, 0));
        appointment1.setCompany(company1);
        appointment1.setDoctor(employee1);
        appointment1.setPatient(patient1);


        appointment2.setName("stomach flu check");
        appointment2.setDescription("This is for flu treatment");
        appointment2.setDate(LocalDate.of(2023, 3, 16));
        appointment2.setStartTime(LocalTime.of(10, 0));
        appointment2.setEndTime(LocalTime.of(11, 0));
        appointment2.setCompany(company1);
        appointment2.setDoctor(employee1);
        appointment2.setPatient(patient1);

        appointment3.setName("stomach flu check");
        appointment3.setDescription("This is for flu treatment");
        appointment3.setDate(LocalDate.of(2023, 3, 17));
        appointment3.setStartTime(LocalTime.of(10, 0));
        appointment3.setEndTime(LocalTime.of(11, 0));
        appointment3.setCompany(company1);
        appointment3.setDoctor(employee2);
        appointment3.setPatient(patient2);

        appointment4.setName("checkup");
        appointment4.setDescription("This is for general treatment");
        appointment4.setDate(LocalDate.of(2023, 3, 17));
        appointment4.setStartTime(LocalTime.of(11, 0));
        appointment4.setEndTime(LocalTime.of(12, 0));
        appointment4.setCompany(company1);
        appointment4.setDoctor(employee2);
        appointment4.setPatient(patient2);

        appointment5.setName("stomach flu check");
        appointment5.setDescription("This is for flu treatment");
        appointment5.setDate(LocalDate.of(2023, 3, 16));
        appointment5.setStartTime(LocalTime.of(10, 0));
        appointment5.setEndTime(LocalTime.of(11, 0));
        appointment5.setCompany(company2);
        appointment5.setDoctor(employee3);
        appointment5.setPatient(patient3);

        appointment6.setName("gastric surgery appt");
        appointment6.setDescription("This is for performing gastric surgery");
        appointment6.setDate(LocalDate.of(2023, 3, 16));
        appointment6.setStartTime(LocalTime.of(11, 0));
        appointment6.setEndTime(LocalTime.of(12, 0));
        appointment6.setCompany(company2);
        appointment6.setDoctor(employee3);
        appointment6.setPatient(patient3);

        appointment7.setName("checkup");
        appointment7.setDescription("This is for general treatment");
        appointment7.setDate(LocalDate.of(2023, 4, 19));
        appointment7.setStartTime(LocalTime.of(8, 20));
        appointment7.setEndTime(LocalTime.of(9, 0));
        appointment7.setCompany(company2);
        appointment7.setDoctor(employee4);
        appointment7.setPatient(patient4);

        appointment8.setName("heart surgery");
        appointment8.setDescription("This is heart surgery");
        appointment8.setDate(LocalDate.of(2023, 4, 20));
        appointment8.setStartTime(LocalTime.of(10, 0));
        appointment8.setEndTime(LocalTime.of(12, 0));
        appointment8.setCompany(company2);
        appointment8.setDoctor(employee4);
        appointment8.setPatient(patient4);



        company1.setName("Spring Hill Doctors");
        company1.setDescription("Hospital staff for spring hill location");
        company1.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement1, announcement2,announcement3,announcement4)));
        company1.setEmployees(new HashSet<Employee>(Arrays.asList(employee1,employee2)));
        company1.setPatients(new HashSet<Patient>(Arrays.asList(patient1,patient2)));
        company1.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment1,appointment2,appointment3,appointment4)));
        company1.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions1,prescriptions2,prescriptions3,prescriptions4)));
        company1.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures1,procedures2,procedures3,procedures4)));

        company1.setName("Nashville Doctors");
        company1.setDescription("Hospital staff for nashville location");
        company1.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement5, announcements6,announcements7,announcements8)));
        company1.setEmployees(new HashSet<Employee>(Arrays.asList(employee3,employee4)));
        company1.setPatients(new HashSet<Patient>(Arrays.asList(patient3,patient4)));
        company1.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment5,appointment6,appointment7,appointment8)));
        company1.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions5,prescriptions6,prescriptions7,prescriptions8)));
        company1.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures5,procedures6,procedures7,procedures8)));

        prescriptions1.setName("Zyphorin");
        prescriptions1.setDescription("all around healer");
        prescriptions1.setCompany(company1);
        prescriptions1.setPrescriber(employee1);
        prescriptions1.setPrescribed(patient1);

        prescriptions2.setName("Nexacure");
        prescriptions2.setDescription("cancer meds");
        prescriptions2.setCompany(company1);
        prescriptions2.setPrescriber(employee1);
        prescriptions2.setPrescribed(patient1);

        prescriptions3.setName("Virolexa");
        prescriptions3.setDescription("stomache medication");
        prescriptions3.setCompany(company1);
        prescriptions3.setPrescriber(employee2);
        prescriptions3.setPrescribed(patient2);

        prescriptions4.setName("Cortivex");
        prescriptions4.setDescription("all around healer");
        prescriptions4.setCompany(company1);
        prescriptions4.setPrescriber(employee2);
        prescriptions4.setPrescribed(patient2);

        prescriptions5.setName("Thermogen");
        prescriptions5.setDescription("Stomache medication");
        prescriptions5.setCompany(company2);
        prescriptions5.setPrescriber(employee3);
        prescriptions5.setPrescribed(patient3);

        prescriptions6.setName("Luminara");
        prescriptions6.setDescription("all around healer");
        prescriptions6.setCompany(company2);
        prescriptions6.setPrescriber(employee3);
        prescriptions6.setPrescribed(patient3);

        prescriptions7.setName("Aquilix");
        prescriptions7.setDescription("all around healer");
        prescriptions7.setCompany(company2);
        prescriptions7.setPrescriber(employee4);
        prescriptions7.setPrescribed(patient4);

        prescriptions8.setName("Serenitol");
        prescriptions8.setDescription("heart medication");
        prescriptions8.setCompany(company2);
        prescriptions8.setPrescriber(employee4);
        prescriptions8.setPrescribed(patient4);

        procedures1.setName("chemo radiation");
        procedures1.setDescription("use radiation to get rid of cancer");
        procedures1.setCompany(company1);
        procedures1.setDoctor(employee1);
        procedures1.setPatient(patient1);

        procedures2.setName("flu shot");
        procedures2.setDescription("flu shot to prevent more flu later");
        procedures2.setCompany(company1);
        procedures2.setDoctor(employee1);
        procedures2.setPatient(patient1);

        procedures3.setName("flu shot");
        procedures3.setDescription("flu shot to prevent more flu later");
        procedures3.setCompany(company1);
        procedures3.setDoctor(employee2);
        procedures3.setPatient(patient2);

        procedures4.setName("antibiotic treatment");
        procedures4.setDescription("treatment to get rid of flu faster");
        procedures4.setCompany(company1);
        procedures4.setDoctor(employee2);
        procedures4.setPatient(patient2);

        procedures5.setName("antibiotic treatment");
        procedures5.setDescription("treatment to get rid of symptoms faster");
        procedures5.setCompany(company2);
        procedures5.setDoctor(employee3);
        procedures5.setPatient(patient3);

        procedures6.setName("gastric surgery");
        procedures6.setDescription("get rid of acid reflux");
        procedures6.setCompany(company2);
        procedures6.setDoctor(employee3);
        procedures6.setPatient(patient3);

        procedures7.setName("echo");
        procedures7.setDescription("see what is going on with patients heart");
        procedures7.setCompany(company2);
        procedures7.setDoctor(employee4);
        procedures7.setPatient(patient4);

        procedures8.setName("heart surgery");
        procedures8.setDescription("fix heart issues so no more heart attacks");
        procedures8.setCompany(company2);
        procedures8.setDoctor(employee4);
        procedures8.setPatient(patient4);

        employee1.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement1,announcement3)));
        employee1.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        employee1.setPatients(new HashSet<Patient>(Arrays.asList(patient1)));
        employee1.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment1,appointment2)));
        employee1.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions1,prescriptions2)));
        employee1.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures1,procedures2)));


        employee2.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement2,announcement4)));
        employee2.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        employee2.setPatients(new HashSet<Patient>(Arrays.asList(patient2)));
        employee2.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment3,appointment4)));
        employee2.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions3,prescriptions4)));
        employee2.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures3,procedures4)));


        employee3.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement5,announcements7)));
        employee3.setCompanies(new HashSet<Company>(Arrays.asList(company2)));
        employee3.setPatients(new HashSet<Patient>(Arrays.asList(patient3)));
        employee3.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment5,appointment6)));
        employee3.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions5,prescriptions6)));
        employee3.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures5,procedures6)));

        employee4.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcements6,announcements8)));
        employee4.setCompanies(new HashSet<Company>(Arrays.asList(company2)));
        employee4.setPatients(new HashSet<Patient>(Arrays.asList(patient4)));
        employee4.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment7,appointment8)));
        employee4.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions7,prescriptions8)));
        employee4.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures7,procedures8)));

        patient1.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        patient1.setEmployees(new HashSet<Employee>(Arrays.asList(employee1)));
        patient1.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment1,appointment2)));
        patient1.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions1,prescriptions2)));
        patient1.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures1,procedures2)));

        patient2.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        patient2.setEmployees(new HashSet<Employee>(Arrays.asList(employee2)));
        patient2.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment3,appointment4)));
        patient2.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions3,prescriptions4)));
        patient2.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures3,procedures4)));

        patient3.setCompanies(new HashSet<Company>(Arrays.asList(company2)));
        patient3.setEmployees(new HashSet<Employee>(Arrays.asList(employee3)));
        patient3.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment5,appointment6)));
        patient3.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions5,prescriptions6)));
        patient3.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures5,procedures6)));

        patient4.setCompanies(new HashSet<Company>(Arrays.asList(company2)));
        patient4.setEmployees(new HashSet<Employee>(Arrays.asList(employee4)));
        patient4.setAppointments(new HashSet<Appointments>(Arrays.asList(appointment7,appointment8)));
        patient4.setPrescriptions(new HashSet<Prescriptions>(Arrays.asList(prescriptions7,prescriptions8)));
        patient4.setProcedures(new HashSet<Procedures>(Arrays.asList(procedures7,procedures8)));



        announcementRepo.saveAllAndFlush(Arrays.asList(
                announcement1, announcement2, announcement3, announcement4, announcement5,announcements6,announcements7));
        companyRepo.saveAllAndFlush(Arrays.asList(company1, company2));
        appointmentsRepo.saveAllAndFlush(Arrays.asList(appointment1,appointment2,appointment3,appointment4,appointment5,appointment6,appointment7,appointment8));
        employeeRepo.saveAllAndFlush(Arrays.asList(employee1,employee2,employee3,employee4));
        patientRepo.saveAllAndFlush(Arrays.asList(patient1,patient2,patient3,patient4));
        prescriptionsRepo.saveAllAndFlush(Arrays.asList(prescriptions1,prescriptions2,prescriptions3,prescriptions4,prescriptions5,prescriptions6,prescriptions7,prescriptions8));
        proceduresRepo.saveAllAndFlush(Arrays.asList(procedures1,procedures2,procedures3,procedures4,procedures5,procedures6,procedures7,procedures8));
    }
}
