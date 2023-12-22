package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Controller.BlackpointController
import com.zonav.Proyectopiensa.Controller.YellowpointController
import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Model.Zones
import com.zonav.Proyectopiensa.Repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ZonesService {
    @Autowired
    lateinit var zonesRepository: ZonesRepository
    @Autowired
    lateinit var redpointRepository: RedpointRepository
    @Autowired
    lateinit var blackpointRepository: BlackpointRepository
    @Autowired
    lateinit var yellowpointRepository: YellowpointRepository
    fun list ():List<Zones>{
        return zonesRepository.findAll()
    }
    fun save(zones: Zones): Zones{
        zones.information?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
        try{

            yellowpointRepository.findById(zones.YellowpointId)
                    ?: throw Exception("Id del cliente no encontrada")

            redpointRepository.findById(zones.RedpointId)
                    ?: throw Exception("Id del cliente no encontrada")

            blackpointRepository.findById(zones.BlackpointId)
                    ?: throw Exception("Id del cliente no encontrada")
            return zonesRepository.save(zones)
        }

        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus .NOT_FOUND,ex.message)
        }
    }
    fun update(zones: Zones): Zones{

        try {

            zonesRepository.findById(zones.id)
                    ?: throw Exception("ID no existe")

            return zonesRepository.save(zones)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(zones: Zones): Zones{
        try{
            val response = zonesRepository.findById(zones.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                information=zones.information //un atributo del modelo
            }
            return zonesRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Zones?{
        return zonesRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = zonesRepository.findById(id)
                    ?: throw Exception("ID no existe")
            zonesRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}