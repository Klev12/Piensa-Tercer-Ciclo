package com.zonav.Proyectopiensa.Repository

import com.zonav.Proyectopiensa.Model.Redpoint
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RedpointRepository : JpaRepository<Redpoint, Long?> {

    fun findById (id: Long?): Redpoint?


}