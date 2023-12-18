package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/Users")   //endpoint
class UsersController {
    @Autowired
    lateinit var usersService: UsersService

    @GetMapping
    fun list ():List <Users>{
        return usersService.list()
    }

}