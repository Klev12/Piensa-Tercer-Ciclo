package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Black_point
import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Repository.Black_pointRepository
import com.zonav.Proyectopiensa.Repository.DeviceRepository
import com.zonav.Proyectopiensa.Repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Black_pointService {
    @Autowired
    lateinit var black_pointRepository: Black_pointRepository

    fun list ():List<Black_point>{
        return black_pointRepository.findAll()
    }

}