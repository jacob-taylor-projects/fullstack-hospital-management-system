import CredentialDTO from "./CredentialDTO";
import ProfileDTO from "./ProfileDTO";

export default interface EmployeeRequestDTO{
    credentials:CredentialDTO,
    profile:ProfileDTO,
    age:number,
    gender:string,
    address:string,
    admin:boolean,
    doctor:boolean,
    specialty:string,
    salary:number
}