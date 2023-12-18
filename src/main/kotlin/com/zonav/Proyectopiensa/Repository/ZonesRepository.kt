package com.zonav.Proyectopiensa.Repository

import com.zonav.Proyectopiensa.Model.Zones
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ZonesRepository : JpaRepository<Zones, Long?> {

    fun findById (id: Long?): Zones?


}