package com.zonav.Proyectopiensa.Model

import jakarta.persistence.*

@Entity
@Table(name = "Users")
class Users{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var FirstName: String?= null
    var lastName: String? = null
    var email: String? = null
    var password: String? = null
    var latitude: Long? = null
    var longitude: Long?= null
}