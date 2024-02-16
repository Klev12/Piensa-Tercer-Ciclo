package com.zonav.Proyectopiensa.Model

import jakarta.persistence.*

@Entity
@Table(name = "Users")
class Users{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "first_Name")
    var firstName: String?= null
    @Column (name = "last_Name")
    var lastName: String? = null
    var username: String? = null
    var email: String? = null
    var password: String? = null
}