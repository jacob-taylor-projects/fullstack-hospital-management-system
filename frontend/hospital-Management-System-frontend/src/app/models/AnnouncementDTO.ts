import BasicEmployeeDTO from "./BasicEmployeeDTO";

export default interface AnnouncementDTO{
    id: number;
    date: string,
    title: string,
    message: string,
    author: BasicEmployeeDTO| undefined
}