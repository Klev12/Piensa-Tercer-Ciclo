package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.Black_point
import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Model.Zones
import com.zonav.Proyectopiensa.Service.Black_pointService
import com.zonav.Proyectopiensa.Service.DeviceService
import com.zonav.Proyectopiensa.Service.UsersService
import com.zonav.Proyectopiensa.Service.ZonesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/Black_point")   //endpoint
class Black_pointController {
    @Autowired
    lateinit var black_pointService: Black_pointService

    @GetMapping
    fun list ():List <Black_point>{
        return black_pointService.list()
    }

}