import AnnouncementDTO from "./AnnouncementDTO";
import AppointmentDTO from "./AppointmentDTO";
import BasicEmployeeDTO from "./BasicEmployeeDTO";
import BasicPatientDTO from "./BasicPatientDTO";
import PrescriptionDTO from "./PrescriptionDTO";
import ProcedureDTO from "./ProcedureDTO";

export default interface CompanyDTO{
    id:number,
    name:string,
    description:string,
    announcements:AnnouncementDTO[],
    employees:BasicEmployeeDTO[],
    patients:BasicPatientDTO[],
    appointments:AppointmentDTO[],
    prescriptions:PrescriptionDTO[],
    procedures:ProcedureDTO[]
}