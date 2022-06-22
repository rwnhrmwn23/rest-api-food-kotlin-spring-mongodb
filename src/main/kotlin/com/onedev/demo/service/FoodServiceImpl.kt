package com.onedev.demo.service

import com.onedev.demo.entity.Food
import com.onedev.demo.repository.FoodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FoodServiceImpl : FoodService {

    @Autowired
    private lateinit var foodRepository: FoodRepository

    override fun getFoods(): List<Food> {
        return foodRepository.getFoods()
    }

    override fun addFood(food: Food): List<Food> {
        return foodRepository.addFood(food.name, food.description)
    }

    override fun updateFood(id: String, food: Food): List<Food> {
        return foodRepository.updateFood(id, food.name, food.description)
    }

    override fun deleteFood(id: String): List<Food> {
        return foodRepository.deleteFood(id)
    }

}