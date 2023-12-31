package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Repository.DeviceRepository
import com.zonav.Proyectopiensa.Repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DeviceService {
    @Autowired
    lateinit var deviceRepository: DeviceRepository

    fun list ():List<Device>{
        return deviceRepository.findAll()
    }
    fun save(device: Device): Device{

        try{
            return deviceRepository.save(device)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(device: Device): Device{
        try {
            deviceRepository.findById(device.id)
                    ?: throw Exception("ID no existe")

            return deviceRepository.save(device)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(device: Device):Device{
        try{
            val response = deviceRepository.findById(device.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                timer=device.timer //un atributo del modelo
            }
            return deviceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Device?{
        return deviceRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = deviceRepository.findById(id)
                    ?: throw Exception("ID no existe")
            deviceRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}