import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeePipe } from './employee.pipe';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeePipe,
    CreateEmployeeComponent,
  ],
  // components
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  //library
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
