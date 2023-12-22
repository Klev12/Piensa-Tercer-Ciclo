package com.zonav.Proyectopiensa.Model

import jakarta.persistence.*

@Entity
@Table(name = "Blackpoint")
class Blackpoint{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var latitude: Long? = null
    var longitude: Long?= null
    var information: String?=null
}