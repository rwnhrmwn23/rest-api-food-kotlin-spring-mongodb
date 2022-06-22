package com.onedev.demo.repository

import com.onedev.demo.entity.Food

interface FoodRepository {
    fun getFoods(): List<Food>
    fun addFood(name: String, description: String): List<Food>
    fun updateFood(id: String, name: String, description: String): List<Food>
    fun deleteFood(id: String): List<Food>
}