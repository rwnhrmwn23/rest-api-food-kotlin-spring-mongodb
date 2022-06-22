package com.onedev.demo.controller

import com.onedev.demo.entity.Food
import com.onedev.demo.response.BaseResponse
import com.onedev.demo.service.FoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/food")
class FoodController {

    @Autowired
    private lateinit var foodService: FoodService

    @GetMapping
    fun getFood() : BaseResponse<List<Food>> {
        return if (foodService.getFoods().isNotEmpty()) {
            BaseResponse(
                message = "Retrieve Food Success",
                status = true,
                data = foodService.getFoods()
            )
        } else {
            BaseResponse(
                message = "Food is Empty",
                status = false,
                data = null
            )
        }
    }

    @PostMapping
    fun addFood(
        @RequestBody food: Food
    ): BaseResponse<List<Food>> {
        return BaseResponse(
            message = "Add Food Data Success",
            status = true,
            data = foodService.addFood(food)
        )
    }

    @PutMapping("/{id}")
    fun updateFood(
        @PathVariable("id") id: String,
        @RequestBody food: Food
    ): BaseResponse<List<Food>> {
        return BaseResponse(
            message = "Update Food Data Success",
            status = true,
            data = foodService.updateFood(id, food)
        )
    }

    @DeleteMapping("/{id}")
    fun deleteFood(
        @PathVariable("id") id: String
    ): BaseResponse<List<Food>> {
        return BaseResponse(
            message = "Delete Food Data Success",
            status = true,
            data = foodService.deleteFood(id)
        )
    }

}
