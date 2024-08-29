import BasicEmployeeDTO from "./BasicEmployeeDTO";
import BasicPatientDTO from "./BasicPatientDTO";

export default interface AppointmentDTO{
    id:number,
    name:string,
    description:string,
    date:Date,
    startTime:Date,
    endTime:Date,
    doctor:BasicEmployeeDTO,
    patient:BasicPatientDTO
}