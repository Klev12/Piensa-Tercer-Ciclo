package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Model.Zones
import com.zonav.Proyectopiensa.Service.DeviceService
import com.zonav.Proyectopiensa.Service.UsersService
import com.zonav.Proyectopiensa.Service.ZonesService
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
@RequestMapping("/Zones")   //endpoint
class ZonesController {
    @Autowired
    lateinit var zonesService: ZonesService

    @GetMapping
    fun list ():List <Zones>{
        return zonesService.list()
    }
    @PostMapping
    fun save (@RequestBody zones: Zones):ResponseEntity<Zones>{
        return ResponseEntity(zonesService.save(zones), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody zones: Zones):ResponseEntity<Zones>{
        return ResponseEntity(zonesService.update(zones), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody zones: Zones):ResponseEntity<Zones>{
        return ResponseEntity(zonesService.updateName(zones), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(zonesService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return zonesService.delete(id)
    }


}