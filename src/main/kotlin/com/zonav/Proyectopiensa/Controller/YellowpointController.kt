package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.*
import com.zonav.Proyectopiensa.Service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/Yellow_point")   //endpoint
class YellowpointController {
    @Autowired
    lateinit var yellowpointService: YellowpointService

    @GetMapping
    fun list ():List <Yellowpoint>{
        return yellowpointService.list()
    }
    @PostMapping
    fun save (@RequestBody yellowpoint: Yellowpoint):ResponseEntity<Yellowpoint>{
        return ResponseEntity(yellowpointService.save(yellowpoint), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody yellowpoint: Yellowpoint):ResponseEntity<Yellowpoint>{
        return ResponseEntity(yellowpointService.update(yellowpoint), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody yellowpoint: Yellowpoint):ResponseEntity<Yellowpoint>{
        return ResponseEntity(yellowpointService.updateName(yellowpoint), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(yellowpointService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return yellowpointService.delete(id)
    }

}