package org.example.types.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "user")
data class User(
    @Id
    @Column(name = "ulid", length = 12, nullable = false)
    val ulid: String,

    @Column(name="platform", nullable = false, length = 25)
    val platform : String,

    @Column(name="username", nullable = false, length = 50, unique = true)
    val username : String,

    @Column(name="access_token", length = 255)
    val accessToken : String,

    @Column(name = "created_at", nullable =  false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "user")
    val account: List<Account> = mutableListOf()
)
