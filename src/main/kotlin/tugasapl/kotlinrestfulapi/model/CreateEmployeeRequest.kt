package tugasapl.kotlinrestfulapi.model

import javax.validation.constraints.NotBlank

data class CreateEmployeeRequest(

    @field:NotBlank
    val id: String?,

    @field:NotBlank
    val name: String?,

    @field:NotBlank
    val position: String?

)