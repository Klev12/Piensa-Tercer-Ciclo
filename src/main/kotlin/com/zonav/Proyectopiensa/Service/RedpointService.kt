package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Redpoint
import com.zonav.Proyectopiensa.Repository.DeviceRepository
import com.zonav.Proyectopiensa.Repository.RedpointRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RedpointService {
    @Autowired
    lateinit var redpointRepository: RedpointRepository
    @Autowired
    lateinit var deviceRepository: DeviceRepository


    fun list ():List<Redpoint>{
        return redpointRepository.findAll()
    }
    fun save(redpoint: Redpoint): Redpoint{
        redpoint.information?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
        try{
            deviceRepository.findById(redpoint.deviceId)
                    ?: throw Exception("Id del cliente no encontrada")
            return redpointRepository.save(redpoint)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(redpoint: Redpoint): Redpoint{
        try {
            redpointRepository.findById(redpoint.id)
                    ?: throw Exception("ID no existe")

            return redpointRepository.save(redpoint)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(redpoint: Redpoint): Redpoint{
        try{
            val response = redpointRepository.findById(redpoint.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                information=redpoint.information //un atributo del modelo
            }
            return redpointRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Redpoint?{
        return redpointRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = redpointRepository.findById(id)
                    ?: throw Exception("ID no existe")
            redpointRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}