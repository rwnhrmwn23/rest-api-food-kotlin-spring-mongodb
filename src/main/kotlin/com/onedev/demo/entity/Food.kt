package com.onedev.demo.entity

import java.util.UUID

data class Food(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    val description: String = ""
)
