package tugasapl.kotlinrestfulapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import tugasapl.kotlinrestfulapi.entity.Employee

interface EmployeeRepository : JpaRepository<Employee, String> {

}