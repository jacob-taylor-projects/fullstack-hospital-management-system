import BasicEmployeeDTO from "./BasicEmployeeDTO";
import BasicPatientDTO from "./BasicPatientDTO";

export default interface ProcedureDTO{
    id:number,
    name:string,
    description:string,
    doctor:BasicEmployeeDTO,
    patient:BasicPatientDTO
}