package com.zonav.Proyectopiensa.Repository

import com.zonav.Proyectopiensa.Model.Points
import com.zonav.Proyectopiensa.Model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PointsRepository : JpaRepository<Points, Long?> {

    fun findById (id: Long?): Points?
}
