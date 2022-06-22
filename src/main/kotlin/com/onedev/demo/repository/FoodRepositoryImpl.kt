package com.onedev.demo.repository

import com.mongodb.client.MongoCollection
import com.onedev.demo.database.DatabaseComponent
import com.onedev.demo.entity.Food
import org.bson.conversions.Bson
import org.litote.kmongo.eq
import org.litote.kmongo.getCollection
import org.litote.kmongo.setValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class FoodRepositoryImpl : FoodRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun foodCollection(): MongoCollection<Food> =
        databaseComponent.database.getDatabase("food").getCollection()

    override fun getFoods(): List<Food> {
        return foodCollection().find().toList()
    }

    override fun addFood(name: String, description: String): List<Food> {
        val newFood = Food(name = name, description = description)
        val insert = foodCollection().insertOne(newFood)
        return if (insert.wasAcknowledged()) {
            getFoods()
        } else {
            throw IllegalStateException("Add Food Data Failed!")
        }
    }

    override fun updateFood(id: String, name: String, description: String): List<Food> {
        val listBson = ArrayList<Bson>()
        listBson.add(setValue(Food::name, name))
        listBson.add(setValue(Food::description, description))

        val update = foodCollection().updateOne(Food::id eq id, listBson)
        return if (update.wasAcknowledged()) {
            getFoods()
        } else {
            throw IllegalStateException("Update Food Data Failed!")
        }
    }

    override fun deleteFood(id: String): List<Food> {
        val delete = foodCollection().deleteOne(Food::id eq id)
        return if (delete.wasAcknowledged()) {
            getFoods()
        } else {
            throw IllegalStateException("Delete Food Data Failed!")
        }
    }
}