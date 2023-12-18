package com.zonav.Proyectopiensa.Repository

import com.zonav.Proyectopiensa.Model.Black_point
import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Yellow_point
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Yellow_pointRepository : JpaRepository<Yellow_point, Long?> {

    fun findById (id: Long?): Yellow_point?


}