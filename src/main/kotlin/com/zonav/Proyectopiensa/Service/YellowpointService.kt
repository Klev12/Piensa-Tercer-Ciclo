package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Yellowpoint
import com.zonav.Proyectopiensa.Repository.YellowpointRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class YellowpointService {
    @Autowired
    lateinit var yellowpointRepository: YellowpointRepository

    fun list ():List<Yellowpoint>{
        return yellowpointRepository.findAll()
    }
    fun save(yellowPoint: Yellowpoint): Yellowpoint{
        yellowPoint.information?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")

        try{
            return yellowpointRepository.save(yellowPoint)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(yellowPoint: Yellowpoint): Yellowpoint{
        try {
            yellowpointRepository.findById(yellowPoint.id)
                    ?: throw Exception("ID no existe")

            return yellowpointRepository.save(yellowPoint)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(yellowPoint: Yellowpoint): Yellowpoint{
        try{
            val response = yellowpointRepository.findById(yellowPoint.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                information=yellowPoint.information //un atributo del modelo
            }
            return yellowpointRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Yellowpoint?{
        return yellowpointRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = yellowpointRepository.findById(id)
                    ?: throw Exception("ID no existe")
            yellowpointRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}