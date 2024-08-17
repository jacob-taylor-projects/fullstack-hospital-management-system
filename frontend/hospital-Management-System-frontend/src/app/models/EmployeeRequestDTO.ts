import CredentialsDTO from "./CredentialsDTO";
import ProfileDTO from "./ProfileDTO";

export default interface EmployeeRequestDTO{
    credentials:CredentialsDTO,
    profile:ProfileDTO,
    age:number,
    gender:string,
    address:string,
    admin:boolean,
    doctor:boolean,
    specialty:string,
    salary:number
}