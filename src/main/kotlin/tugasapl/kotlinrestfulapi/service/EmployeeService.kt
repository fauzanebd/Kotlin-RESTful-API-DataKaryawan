package tugasapl.kotlinrestfulapi.service

import tugasapl.kotlinrestfulapi.model.CreateEmployeeRequest
import tugasapl.kotlinrestfulapi.model.EmployeeResponse
import tugasapl.kotlinrestfulapi.model.ListEmployeeRequest
import tugasapl.kotlinrestfulapi.model.UpdateEmployeeRequest

interface EmployeeService {

    fun create(createEmployeeRequest: CreateEmployeeRequest): EmployeeResponse

    fun get(id: String): EmployeeResponse

    fun update(id: String, updateEmployeeRequest: UpdateEmployeeRequest): EmployeeResponse

    fun delete(id: String)

    fun list(listEmployeeRequest: ListEmployeeRequest): List<EmployeeResponse>
}
