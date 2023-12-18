package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Repository.DeviceRepository
import com.zonav.Proyectopiensa.Repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeviceService {
    @Autowired
    lateinit var deviceRepository: DeviceRepository

    fun list ():List<Device>{
        return deviceRepository.findAll()
    }

}