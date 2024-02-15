package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Device
import com.zonav.Proyectopiensa.Model.Points
import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Repository.DeviceRepository
import com.zonav.Proyectopiensa.Repository.PointsRepository
import com.zonav.Proyectopiensa.Repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PointsService {
    @Autowired
    lateinit var pointsRepository: PointsRepository

    fun list ():List<Points>{
        return pointsRepository.findAll()
    }
    fun save(points: Points): Points{

        try{
            return pointsRepository.save(points)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(points: Points): Points{
        try {
            pointsRepository.findById(points.id)
                    ?: throw Exception("ID no existe")

            return pointsRepository.save(points)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(points: Points):Points{
        try{
            val response = pointsRepository.findById(points.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                color=points.color //un atributo del modelo
            }
            return pointsRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Points?{
        return pointsRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = pointsRepository.findById(id)
                    ?: throw Exception("ID no existe")
            pointsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}