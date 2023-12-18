package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Service.DeviceService
import com.zonav.Proyectopiensa.Service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/Device")   //endpoint
class DeviceController {
    @Autowired
    lateinit var deviceService: DeviceService

    @GetMapping
    fun list ():List <Device>{
        return deviceService.list()
    }

}