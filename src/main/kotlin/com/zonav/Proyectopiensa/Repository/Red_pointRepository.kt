package com.zonav.Proyectopiensa.Repository

import com.zonav.Proyectopiensa.Model.Black_point
import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Red_point
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Red_pointRepository : JpaRepository<Red_point, Long?> {

    fun findById (id: Long?): Red_point?


}