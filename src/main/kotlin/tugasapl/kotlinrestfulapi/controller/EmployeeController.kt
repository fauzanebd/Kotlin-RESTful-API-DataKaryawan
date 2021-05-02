package tugasapl.kotlinrestfulapi.controller

import org.springframework.web.bind.annotation.*
import tugasapl.kotlinrestfulapi.entity.Employee
import tugasapl.kotlinrestfulapi.model.*
import tugasapl.kotlinrestfulapi.service.EmployeeService

@RestController
class EmployeeController(val employeeService: EmployeeService) {

    @PostMapping(
        value = ["/api/employees"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createEmployee(@RequestBody body: CreateEmployeeRequest): WebResponse<EmployeeResponse> {
        val employeeResponse =  employeeService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = employeeResponse
        )
    }

    @GetMapping(
        value = ["/api/employees/{id_employee}"],
        produces = ["application/json"]
    )
    fun getEmployee(@PathVariable("id_employee") id: String): WebResponse<EmployeeResponse>{
        val employeeResponse = employeeService.get(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = employeeResponse
        )
    }

    @PutMapping(
        value = ["/api/employees/{id_employee}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateEmployee(@PathVariable("id_employee") id: String,
                       @RequestBody updateEmployeeRequest: UpdateEmployeeRequest): WebResponse<EmployeeResponse>{
        val employeeResponse = employeeService.update(id, updateEmployeeRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = employeeResponse
        )
    }

    @DeleteMapping(
        value = ["/api/employees/{id_employee}"],
        produces = ["application/json"]
    )
    fun deleteEmployee(@PathVariable("id_employee") id:String): WebResponse<String>{
        employeeService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = "$id deleted"
        )
    }

    @GetMapping(
        value = ["/api/employees"],
        produces = ["application/json"]
    )
    fun listEmployees(@RequestParam(value="page", defaultValue="0") page: Int,
                      @RequestParam(value="size", defaultValue="10") size: Int): WebResponse<List<EmployeeResponse>>{
        val request = ListEmployeeRequest(page = page, size = size)
        val responses = employeeService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }
}