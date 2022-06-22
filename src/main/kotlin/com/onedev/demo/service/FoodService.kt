package com.onedev.demo.service

import com.onedev.demo.entity.Food

interface FoodService {
    fun getFoods(): List<Food>
    fun addFood(food: Food): List<Food>
    fun updateFood(id: String, food: Food): List<Food>
    fun deleteFood(id: String): List<Food>
}