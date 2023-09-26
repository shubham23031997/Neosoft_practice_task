import axios from "axios";
const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1";

class EmployeeService {
  getEmployees(employee) {
    return axios.get(EMPLOYEE_API_BASE_URL + "/employees", employee);
  }
  saveEmployee(employee) {
    return axios.post(EMPLOYEE_API_BASE_URL + "/add-employee", employee);
  }
}
export default new EmployeeService();
