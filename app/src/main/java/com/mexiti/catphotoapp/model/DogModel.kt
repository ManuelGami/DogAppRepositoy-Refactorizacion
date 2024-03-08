package com.mexiti.catphotoapp.model

import kotlinx.serialization.Serializable

// esta data class es para tranbajar los datos del jason

// para decirle que va a leer una jason se pone eso
@Serializable
data class DogModel(
    // creamos las variables para separar las partes del objeto del jason
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,

)
