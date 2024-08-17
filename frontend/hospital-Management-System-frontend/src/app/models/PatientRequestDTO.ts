import CredentialsDTO from "./CredentialsDTO";
import ProfileDTO from "./ProfileDTO";

export default interface PatientRequestDTO{
    credentials:CredentialsDTO,
    profile:ProfileDTO,
    age:number,
    gender:string,
    address:string,
    prognosis:string
}