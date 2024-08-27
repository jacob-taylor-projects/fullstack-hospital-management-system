import BasicEmployeeDTO from "./BasicEmployeeDTO";
import BasicPatientDTO from "./BasicPatientDTO";

export default interface PrescriptionDTO {
    id:number,
    name:string,
    description:string,
    prescriber:BasicEmployeeDTO,
    prescribed:BasicPatientDTO
}