package com.zonav.Proyectopiensa.Model

import jakarta.persistence.*

@Entity
@Table(name = "Device")
class Device{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var latitude: Double?= null
    var longitude: Double? = null
    var timer: Long? = null

}