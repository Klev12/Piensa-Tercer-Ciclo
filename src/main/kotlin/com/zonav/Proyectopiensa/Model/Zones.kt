package com.zonav.Proyectopiensa.Model

import jakarta.persistence.*

@Entity
@Table(name = "Zones")
class Zones{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var information: String?= null
    @Column(name="Black_point_id")
    var BlackpointId: Long? = null
    @Column(name="Yellow_point_id")
    var YellowpointId: Long? = null
    @Column(name="Red_point_id")
    var RedpointId: Long? = null

}