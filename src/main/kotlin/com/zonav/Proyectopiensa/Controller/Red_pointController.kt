package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.*
import com.zonav.Proyectopiensa.Service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/Red_point")   //endpoint
class Red_pointController {
    @Autowired
    lateinit var red_pointService: Red_pointService

    @GetMapping
    fun list ():List <Red_point>{
        return red_pointService.list()
    }

}