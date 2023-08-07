import { Pipe, PipeTransform } from '@angular/core';
import { DatePipe } from '@angular/common';

@Pipe({
  name: 'formattedDate',
})
export class EmployeePipe implements PipeTransform {
  transform(value: Date): string {
    if (value) {
      const datePipe = new DatePipe('en-US');
      return datePipe.transform(value, 'dd/MM/yyyy') + '';
    }
    return '';
  }
}
