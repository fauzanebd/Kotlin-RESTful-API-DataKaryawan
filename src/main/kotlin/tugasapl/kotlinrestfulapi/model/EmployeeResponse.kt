package tugasapl.kotlinrestfulapi.model

import java.util.*

data class EmployeeResponse(

    val id: String,

    val name: String,

    val position: String,

    val createdAt: Date,

    val updatedAt: Date?

)