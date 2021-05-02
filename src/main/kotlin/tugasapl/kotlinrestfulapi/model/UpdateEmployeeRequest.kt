package tugasapl.kotlinrestfulapi.model

import javax.validation.constraints.NotBlank

data class UpdateEmployeeRequest(

    @field:NotBlank
    val name: String?,

    @field:NotBlank
    val position: String?

)