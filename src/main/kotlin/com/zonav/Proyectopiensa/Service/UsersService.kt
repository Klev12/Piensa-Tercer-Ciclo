package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class UsersService {
    @Autowired
    lateinit var usersRepository: UsersRepository

    fun list ():List<Users>{
        return usersRepository.findAll()
    }
    fun save(users: Users): Users{
        users.firstName?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
        try{
            return usersRepository.save(users)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(users: Users): Users{
        try {
            usersRepository.findById(users.id)
                    ?: throw Exception("ID no existe")

            return usersRepository.save(users)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(users: Users): Users{
        try{
            val response = usersRepository.findById(users.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                firstName=users.firstName //un atributo del modelo
            }
            return usersRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Users?{
        return usersRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = usersRepository.findById(id)
                    ?: throw Exception("ID no existe")
            usersRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}