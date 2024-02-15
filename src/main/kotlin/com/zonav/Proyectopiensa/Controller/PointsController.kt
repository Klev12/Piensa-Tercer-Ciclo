package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.Points
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Service.PointsService
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
@RequestMapping("/Points")   //endpoint
class PointsController {
    @Autowired
    lateinit var pointsService: PointsService

    @GetMapping
    fun list ():List <Points>{
        return pointsService.list()
    }
    @PostMapping
    fun save (@RequestBody points: Points):ResponseEntity<Points>{
        return ResponseEntity(pointsService.save(points), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody points: Points):ResponseEntity<Points>{
        return ResponseEntity(pointsService.update(points), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody points: Points):ResponseEntity<Points>{
        return ResponseEntity(pointsService.updateName(points), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(pointsService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return pointsService.delete(id)
    }

}