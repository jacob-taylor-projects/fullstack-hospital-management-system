import CredentialDTO from "./CredentialDTO";
import ProfileDTO from "./ProfileDTO";

export default interface PatientRequestDTO{
    credentials:CredentialDTO,
    profile:ProfileDTO,
    age:number,
    gender:string,
    address:string,
    prognosis:string
}