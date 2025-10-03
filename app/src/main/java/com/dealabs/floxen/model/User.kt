package com.dealabs.floxen.model

data class UserData(
    val uid: String = "",
    val email: String = "",
    val fullName: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

data class SocialPost(
    val id: String = "",
    val userId: String = "",
    val userName: String = "",
    val content: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val likes: Int = 0,
    val likedBy: Map<String, Boolean> = emptyMap()
)