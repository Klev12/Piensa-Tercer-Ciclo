package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
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
    @PostMapping
    fun save (@RequestBody users: Users):ResponseEntity<Users>{
        return ResponseEntity(usersService.save(users), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody users: Users):ResponseEntity<Users>{
        return ResponseEntity(usersService.update(users), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody users: Users):ResponseEntity<Users>{
        return ResponseEntity(usersService.updateName(users), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(usersService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return usersService.delete(id)
    }


}