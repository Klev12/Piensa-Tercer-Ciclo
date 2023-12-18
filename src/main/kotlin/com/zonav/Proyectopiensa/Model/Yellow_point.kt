package com.zonav.Proyectopiensa.Model

import jakarta.persistence.*

@Entity
@Table(name = "Yellow_point")
class Yellow_point{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var latitude: Double? = null
    var longitude: Double?= null
    var information: String?=null
}