package tugasapl.kotlinrestfulapi.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import tugasapl.kotlinrestfulapi.entity.Employee
import tugasapl.kotlinrestfulapi.error.NotFoundException
import tugasapl.kotlinrestfulapi.model.CreateEmployeeRequest
import tugasapl.kotlinrestfulapi.model.EmployeeResponse
import tugasapl.kotlinrestfulapi.model.ListEmployeeRequest
import tugasapl.kotlinrestfulapi.model.UpdateEmployeeRequest
import tugasapl.kotlinrestfulapi.repository.EmployeeRepository
import tugasapl.kotlinrestfulapi.service.EmployeeService
import tugasapl.kotlinrestfulapi.validation.ValidationUtil
import java.util.*
import java.util.stream.Collectors

@Service
class EmployeeServiceImpl(
    val employeeRepository: EmployeeRepository,
    val validationUtil: ValidationUtil
    ) : EmployeeService {

    override fun create(createEmployeeRequest: CreateEmployeeRequest): EmployeeResponse {
        validationUtil.validate(createEmployeeRequest)

        val employee = Employee(
            id = createEmployeeRequest.id!!,
            name = createEmployeeRequest.name!!,
            position = createEmployeeRequest.position!!,
            createdAt = Date(),
            updatedAt = null
        )

        employeeRepository.save(employee)

        return convertEmployeeToEmployeeResponse(employee)
    }

    override fun get(id: String): EmployeeResponse {
        val employee = findEmployeeByIdOrThrow(id)
        return convertEmployeeToEmployeeResponse(employee)
    }

    override fun update(id: String, updateEmployeeRequest: UpdateEmployeeRequest): EmployeeResponse {
        val employee = findEmployeeByIdOrThrow(id)
        validationUtil.validate(updateEmployeeRequest)
        employee.apply {
            name = updateEmployeeRequest.name!!
            position = updateEmployeeRequest.position!!
            updatedAt = Date()
        }
        employeeRepository.save(employee)
        return convertEmployeeToEmployeeResponse(employee)
    }

    override fun delete(id: String) {
        val employee = findEmployeeByIdOrThrow(id)
        employeeRepository.delete(employee)
    }

    override fun list(listEmployeeRequest: ListEmployeeRequest): List<EmployeeResponse> {
        val page = employeeRepository.findAll(PageRequest.of(listEmployeeRequest.page, listEmployeeRequest.size))
        val employees: List<Employee> = page.get().collect(Collectors.toList())
        return employees.map{convertEmployeeToEmployeeResponse(it)}
    }

    private fun findEmployeeByIdOrThrow(id: String): Employee{
        val employee = employeeRepository.findByIdOrNull(id)
        if (employee==null){
            throw NotFoundException()
        }  else {
            return employee
        }
    }

    private fun convertEmployeeToEmployeeResponse(employee: Employee): EmployeeResponse{
        return EmployeeResponse(
            id = employee.id,
            name = employee.name,
            position = employee.position,
            createdAt = employee.createdAt,
            updatedAt = employee.updatedAt
        )
    }
}