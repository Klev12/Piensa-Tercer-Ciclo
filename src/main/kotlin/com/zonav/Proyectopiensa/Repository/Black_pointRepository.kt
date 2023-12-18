package com.zonav.Proyectopiensa.Repository

import com.zonav.Proyectopiensa.Model.Black_point
import com.zonav.Proyectopiensa.Model.Device
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Black_pointRepository : JpaRepository<Black_point, Long?> {

    fun findById (id: Long?): Black_point?


}