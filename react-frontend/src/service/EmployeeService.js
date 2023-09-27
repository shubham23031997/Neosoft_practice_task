import axios from "axios";
const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1";

class EmployeeService {
  getEmployees(employee) {
    return axios.get(EMPLOYEE_API_BASE_URL + "/employees", employee);
  }
  saveEmployee(employee) {
    return axios.post(EMPLOYEE_API_BASE_URL + "/add-employee", employee);
  }
  updateEmployee(id, employee) {
    return axios.put(
      EMPLOYEE_API_BASE_URL + "/update-employee/" + id,
      employee
    );
  }
  deleteEmployee(id) {
    return axios.delete(EMPLOYEE_API_BASE_URL + "/delete-employee/" + id);
  }
  getEmployeeById(id) {
    return axios.get(EMPLOYEE_API_BASE_URL + "/getEmployeeById/" + id);
  }
}
export default new EmployeeService();
