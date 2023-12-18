package com.zonav.Proyectopiensa.Model

import jakarta.persistence.*

@Entity
@Table(name = "Red_point")
class Red_point{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var latitude: Long? = null
    var longitude: Long?= null
    var information: String?=null
    @Column(name="device_id")
    var deviceId: String?=null
}