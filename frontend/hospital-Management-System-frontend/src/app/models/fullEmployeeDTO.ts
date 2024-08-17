import AnnouncementDTO from "./AnnouncementDTO";
import AppointmentDTO from "./AppointmentDTO";
import BasicPatientDTO from "./BasicPatientDTO";
import CompanyDTO from "./CompanyDTO";
import PrescriptionDTO from "./PrescriptionDTO";
import ProcedureDTO from "./ProcedureDTO";
import ProfileDTO from "./ProfileDTO";

export default interface fullEmployeeDTO{
    id:number,
    profile:ProfileDTO,
    age:number,
    gender:string,
    address:string,
    admin:boolean,
    doctor:boolean,
    specialty:string,
    salary:number,
    announcements:AnnouncementDTO[],
    companies:CompanyDTO[],
    patients:BasicPatientDTO[],
    appointments:AppointmentDTO[],
    prescriptions:PrescriptionDTO[],
    procedures:ProcedureDTO[]
}
