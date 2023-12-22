package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.*
import com.zonav.Proyectopiensa.Service.*
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
@RequestMapping("/Red_point")   //endpoint
class RedpointController {
    @Autowired
    lateinit var redpointService: RedpointService

    @GetMapping
    fun list ():List <Redpoint>{
        return redpointService.list()
    }
    @PostMapping
    fun save (@RequestBody redpoint: Redpoint):ResponseEntity<Redpoint>{
        return ResponseEntity(redpointService.save(redpoint), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody redpoint: Redpoint):ResponseEntity<Redpoint>{
        return ResponseEntity(redpointService.update(redpoint), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody redpoint: Redpoint):ResponseEntity<Redpoint>{
        return ResponseEntity(redpointService.updateName(redpoint), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(redpointService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return redpointService.delete(id)
    }


}