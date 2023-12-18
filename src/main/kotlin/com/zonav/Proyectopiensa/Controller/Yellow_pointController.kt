package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.*
import com.zonav.Proyectopiensa.Service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/Yellow_point")   //endpoint
class Yellow_pointController {
    @Autowired
    lateinit var yellow_pointService : Yellow_pointService

    @GetMapping
    fun list ():List <Yellow_point>{
        return yellow_pointService.list()
    }

}