package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Blackpoint
import com.zonav.Proyectopiensa.Repository.BlackpointRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class BlackpointService {
    @Autowired
    lateinit var blackpointRepository: BlackpointRepository

    fun list ():List<Blackpoint>{
        return blackpointRepository.findAll()
    }
    fun save(blackpoint: Blackpoint): Blackpoint{
        blackpoint.information?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")

        try{
            return blackpointRepository.save(blackpoint)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(blackpoint: Blackpoint): Blackpoint{
        try {
            blackpointRepository.findById(blackpoint.id)
                    ?: throw Exception("ID no existe")

            return blackpointRepository.save(blackpoint)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(blackpoint: Blackpoint): Blackpoint{
        try{
            val response = blackpointRepository.findById(blackpoint.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                information=blackpoint.information
            }
            return blackpointRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Blackpoint?{
        return blackpointRepository.findById(id)
    }
    fun delete(id: Long?):Boolean?{
        try{
            val response = blackpointRepository.findById(id)
                    ?: throw Exception("ID no existe")
            blackpointRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }




}