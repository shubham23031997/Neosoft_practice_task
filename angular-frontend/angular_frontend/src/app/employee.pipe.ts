import { Pipe, PipeTransform } from '@angular/core';
import { DatePipe } from '@angular/common';

@Pipe({
  name: 'formattedDate',
})
export class EmployeePipe implements PipeTransform {
  transform(value: any): string {
    if (value) {
      const datePipe = new DatePipe('en-US');
      return datePipe.transform(value, 'dd/MM/yyyy') + '';
    }
    return '';
  }

  // date: Date = new Date();
  // //formattedDate: string;
  // Date: any;
  // dateString = '2023-08-08';
  // // string parsedDate;
  // parsedDate: Date = new Date(this.dateString);
  // constructor(private datePipe: DatePipe) {
  //   this.Date = this.datePipe.transform(this.date, 'dd-MM-yyyy');
  // }
}
