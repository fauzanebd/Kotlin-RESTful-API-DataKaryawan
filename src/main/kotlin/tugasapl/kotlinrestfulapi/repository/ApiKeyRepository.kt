package tugasapl.kotlinrestfulapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import tugasapl.kotlinrestfulapi.entity.ApiKey

interface ApiKeyRepository : JpaRepository<ApiKey, String> {
}