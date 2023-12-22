package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.Blackpoint
import com.zonav.Proyectopiensa.Service.BlackpointService
import org.springframework.beans.factory.annotation.Autowired
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
@RequestMapping("/Black_point")   //endpoint
class BlackpointController{
    @Autowired
    lateinit var blackpointService: BlackpointService

    @GetMapping
    fun list ():List <Blackpoint>{
        return blackpointService.list()
    }
    @PostMapping
    fun save (@RequestBody blackPoint: Blackpoint):ResponseEntity<Blackpoint>{
        return ResponseEntity(blackpointService.save(blackPoint), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody blackPoint: Blackpoint):ResponseEntity<Blackpoint>{
        return ResponseEntity(blackpointService.update(blackPoint), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody blackPoint: Blackpoint):ResponseEntity<Blackpoint>{
        return ResponseEntity(blackpointService.updateName(blackPoint), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(blackpointService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return blackpointService.delete(id)
    }



}