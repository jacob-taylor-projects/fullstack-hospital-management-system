import AppointmentDTO from "./AppointmentDTO";
import BasicEmployeeDTO from "./BasicEmployeeDTO";
import CompanyDTO from "./CompanyDTO";
import PrescriptionDTO from "./PrescriptionDTO";
import ProcedureDTO from "./ProcedureDTO";
import ProfileDTO from "./ProfileDTO";

export default interface FullPatientDTO{
    id:number,
    profile:ProfileDTO,
    age:number,
    gender:string,
    address:string,
    prognosis:string,
    companies:CompanyDTO[],
    employees:BasicEmployeeDTO[],
    appointments:AppointmentDTO[],
    prescriptions:PrescriptionDTO[]
    procedures:ProcedureDTO[]
}