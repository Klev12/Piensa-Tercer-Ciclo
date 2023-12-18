package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Black_point
import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Model.Yellow_point
import com.zonav.Proyectopiensa.Repository.Black_pointRepository
import com.zonav.Proyectopiensa.Repository.DeviceRepository
import com.zonav.Proyectopiensa.Repository.UsersRepository
import com.zonav.Proyectopiensa.Repository.Yellow_pointRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class Yellow_pointService {
    @Autowired
    lateinit var yellow_pointRepository: Yellow_pointRepository

    fun list ():List<Yellow_point>{
        return yellow_pointRepository.findAll()
    }

}