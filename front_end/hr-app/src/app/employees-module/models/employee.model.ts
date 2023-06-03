export class Employee {
    id: string;
    fullName: string;
    department: string;
    email: string;
    address: string;
  
    constructor(id: string, fullName: string, department: string, email: string, address: string){
      this.id = id;
      this.fullName = fullName;
      this.department = department;
      this.email = email;
      this.address = address;
    }
  }