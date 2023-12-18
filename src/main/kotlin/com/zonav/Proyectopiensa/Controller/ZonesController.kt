package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Model.Zones
import com.zonav.Proyectopiensa.Service.DeviceService
import com.zonav.Proyectopiensa.Service.UsersService
import com.zonav.Proyectopiensa.Service.ZonesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/Zones")   //endpoint
class ZonesController {
    @Autowired
    lateinit var zonesService: ZonesService

    @GetMapping
    fun list ():List <Zones>{
        return zonesService.list()
    }

}