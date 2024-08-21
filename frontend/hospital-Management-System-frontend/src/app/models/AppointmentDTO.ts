import BasicEmployeeDTO from "./BasicEmployeeDTO";
import BasicPatientDTO from "./BasicPatientDTO";

export default interface AppointmentDTO{
    id:number,
    name:string,
    description:string,
    date:string,
    startTime:string,
    endTime:string,
    doctor:BasicEmployeeDTO,
    patient:BasicPatientDTO
}