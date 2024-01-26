package com.example.myapplicationnavigation.data.remote

import com.example.myapplicationnavigation.model.people.PeopleModelItem
import com.example.myapplicationnavigation.model.room.RoomModelItem
import retrofit2.http.GET

interface ApiService {

    @GET(ApiDetails.END_POINT_PEOPLE)
    suspend fun getPeople(): List<PeopleModelItem>

    @GET(ApiDetails.END_POINT_ROOM)
    suspend fun getRooms(): List<RoomModelItem>

}