package ru.netology

import ru.netology.WallService.add
import ru.netology.WallService.update

fun main() {
    val post = Post()

}

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "текст",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val postType: String = "запись",
    val signerId: Int = 0,
    val isFavorite: Boolean = false
)

object WallService {
    private var posts = emptyArray<Post>()
    private var uniqId = 0


    fun add(post: Post): Post {
        posts += post.copy(id = uniqId++)
        return posts.last()
    }


    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id==newPost.id){
                posts[index] = newPost.copy()
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        uniqId = 0

    }

    object likes

}
