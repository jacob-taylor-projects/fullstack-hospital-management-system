import ProfileDTO from "./ProfileDTO";

export default interface BasicEmployeeDTO{
    id: number,
    profile:ProfileDTO,
    age:number,
    gender:string,
    address:string,
    admin:boolean,
    doctor:boolean,
    specialty:string,
    salary:number
}