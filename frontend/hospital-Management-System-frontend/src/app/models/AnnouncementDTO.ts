import FullEmployeeDTO from "./FullEmployeeDTO";

export default interface AnnouncementDTO {
    id: number,
    date: string,
    title: string,
    message: string,
    author: FullEmployeeDTO | undefined
};