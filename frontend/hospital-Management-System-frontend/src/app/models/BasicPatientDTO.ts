import ProfileDTO from "./ProfileDTO";

export default interface BasicPatientDTO{
    id:number,
    profile:ProfileDTO,
    age:number,
    gender:string,
    address:string,
    prognosis:string
}
