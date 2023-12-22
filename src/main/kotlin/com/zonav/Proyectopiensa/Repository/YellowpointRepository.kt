package com.zonav.Proyectopiensa.Repository

import com.zonav.Proyectopiensa.Model.Yellowpoint
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface YellowpointRepository : JpaRepository<Yellowpoint, Long?> {

    fun findById (id: Long?): Yellowpoint?


}