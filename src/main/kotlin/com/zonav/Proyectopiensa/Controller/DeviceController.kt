package com.zonav.Proyectopiensa.Controller

import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Service.DeviceService
import com.zonav.Proyectopiensa.Service.UsersService
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
@RequestMapping("/Device")   //endpoint
class DeviceController {
    @Autowired
    lateinit var deviceService: DeviceService

    @GetMapping
    fun list ():List <Device>{
        return deviceService.list()
    }
    @PostMapping
    fun save (@RequestBody device: Device):ResponseEntity<Device>{
        return ResponseEntity(deviceService.save(device), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody device: Device):ResponseEntity<Device>{
        return ResponseEntity(deviceService.update(device), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody device: Device):ResponseEntity<Device>{
        return ResponseEntity(deviceService.updateName(device), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(deviceService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return deviceService.delete(id)
    }

}