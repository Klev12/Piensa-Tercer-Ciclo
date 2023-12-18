package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Model.Zones
import com.zonav.Proyectopiensa.Repository.DeviceRepository
import com.zonav.Proyectopiensa.Repository.UsersRepository
import com.zonav.Proyectopiensa.Repository.ZonesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ZonesService {
    @Autowired
    lateinit var zonesRepository: ZonesRepository

    fun list ():List<Zones>{
        return zonesRepository.findAll()
    }

}