package com.mexiti.catphotoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mexiti.catphotoapp.R
import com.mexiti.catphotoapp.model.DogModel

import com.mexiti.catphotoapp.ui.viewmodel.DogUiState


@Composable

fun HomeScreen(
    dogUiState: DogUiState,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
               ){
    when(dogUiState){
        is DogUiState.Loading->LoadingScreen(modifier=modifier.fillMaxSize())
        is DogUiState.Success-> PhotosGridScreen(photos = (dogUiState.photos) ,modifier=modifier.fillMaxWidth())
        is DogUiState.Error->ErrorScreen(modifier=modifier.fillMaxSize())
    }
}

@Composable

fun ErrorScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.error_load), contentDescription = "error")
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.loader), contentDescription = "cargando")
        Text(text = "error en la conexion")
    }
}


@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
        ){
        Text(text = photos )
    }
}
@Composable
fun DogPhotoCard(photo:DogModel,modifier: Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    )
    {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photo.url)
                .crossfade(true)
                .build(),
            error = painterResource(id = R.drawable.error_404),
            placeholder = painterResource(id = R.drawable.carga),
            contentDescription = stringResource(R.string.dog_image),
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PhotosGridScreen(
    photos: List<DogModel>,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(250.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding
    ){
        items(
            items = photos,
            key = {
                    photo -> photo.id
            }
        ){
                photo-> DogPhotoCard(photo = photo,
            modifier = modifier
                .padding(4.dp)
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .clip(shape = CircleShape)
                )
        }
    }

}
@Preview
@Composable
fun HomeScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        //HomeScreen()
    }

}
