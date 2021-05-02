package tugasapl.kotlinrestfulapi.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="employees")
data class Employee(

    @Id
    val id: String,

    @Column(name="name")
    var name: String,

    @Column(name="position")
    var position: String,

    @Column(name="created_at")
    var createdAt: Date,

    @Column(name="updated_at")
    var updatedAt: Date?

)