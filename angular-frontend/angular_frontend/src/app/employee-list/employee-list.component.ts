import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
// import { Router } from '@angular/router';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  employees!: Employee[];
  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    // this.employees = [
    //   {
    //     id: 1,
    //     firstName: 'shubham',
    //     lastName: 'mali',
    //     emailId: 'mali@gmail.com',
    //   },
    //   {
    //     id: 2,
    //     firstName: 'kunal',
    //     lastName: 'marathe',
    //     emailId: 'marathe@gmail.com',
    //   },
    // ];

    this.getEmployees();
  }

  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe((data) => {
      this.employees = data;
    });
  }
}
