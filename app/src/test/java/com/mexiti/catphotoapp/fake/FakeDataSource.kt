package com.mexiti.catphotoapp.fake

import com.mexiti.catphotoapp.model.DogModel
object FakeDataSource{
    const val idOne = "idDog1"
    const val idTwo = "idDog2"
    const val imgOne = "url.1"
    const val imgTwo = "url.2"
    const val widthOne = 200
    const val heigtOne = 200
    const val widthTwo = 350
    const val heightTwo = 350


    val photoList = listOf(
        DogModel(
            idOne,
            imgOne,
            widthOne,
            heightTwo
        ),
        DogModel(idTwo,
            imgTwo,
            widthTwo,
            heightTwo)
    )
}