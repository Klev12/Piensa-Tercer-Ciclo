package com.zonav.Proyectopiensa.Service

import com.zonav.Proyectopiensa.Model.Users
import com.zonav.Proyectopiensa.Repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UsersService {
    @Autowired
    lateinit var usersRepository: UsersRepository

    fun list ():List<Users>{
        return usersRepository.findAll()
    }

}