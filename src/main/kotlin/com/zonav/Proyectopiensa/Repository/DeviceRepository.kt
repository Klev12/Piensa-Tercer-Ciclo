package com.zonav.Proyectopiensa.Repository

import com.zonav.Proyectopiensa.Model.Device
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeviceRepository : JpaRepository<Device, Long?> {

    fun findById (id: Long?): Device?


}