package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Black_point
import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Red_point
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Repository.Black_pointRepository
import com.zonav.Proyectopiensa.Repository.DeviceRepository
import com.zonav.Proyectopiensa.Repository.Red_pointRepository
import com.zonav.Proyectopiensa.Repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Red_pointService {
    @Autowired
    lateinit var red_pointRepository: Red_pointRepository

    fun list ():List<Red_point>{
        return red_pointRepository.findAll()
    }

}