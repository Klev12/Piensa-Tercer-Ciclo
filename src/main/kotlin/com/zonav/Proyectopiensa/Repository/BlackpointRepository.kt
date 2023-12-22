package com.zonav.Proyectopiensa.Repository

import com.zonav.Proyectopiensa.Model.Blackpoint
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlackpointRepository : JpaRepository<Blackpoint, Long?> {

    fun findById (id: Long?): Blackpoint?


}