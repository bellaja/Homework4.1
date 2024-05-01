import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.netology.Post
import ru.netology.WallService

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val service = WallService
        service.add(
            Post(
                ownerId = 0, fromId = 0, date = 0, text = "текст", replyOwnerId = 0,
                replyPostId = 0, postType = "запись", signerId = 0, isFavorite = false
            )
        )

        service.add(
            Post(
                ownerId = 0, fromId = 0, date = 0, text = "текст", replyOwnerId = 0,
                replyPostId = 0, postType = "запись", signerId = 0, isFavorite = false
            )
        )

        val result = service.add(Post())
        assertEquals(
            Post(
                id = 2,
                ownerId = 0,
                fromId = 0,
                date = 0,
                text = "текст",
                replyOwnerId = 0,
                replyPostId = 0,
                postType = "запись",
                signerId = 0,
                isFavorite = false
            ), result
        )

    }


    @Before
    fun clearBeforeTest1() {
        WallService.clear()

    }

    @Test
    fun updateTrue() {
        val service = WallService

        service.add(
            Post(
                ownerId = 0, fromId = 0, date = 0, text = "текст", replyOwnerId = 0,
                replyPostId = 0, postType = "запись", signerId = 0, isFavorite = false
            )
        )
        service.add(
            Post(
                ownerId = 1, fromId = 0, date = 0, text = "текст", replyOwnerId = 0,
                replyPostId = 0, postType = "запись", signerId = 0, isFavorite = false
            )
        )

        val update = Post(
            id = 0, ownerId = 0, fromId = 0, date = 0, text = "текст", replyOwnerId = 0,
            replyPostId = 0, postType = "запись", signerId = 0, isFavorite = false
        )


        val result = service.update(update)


        assertTrue(result)
    }

    @Before
    fun clearBeforeTest2() {
        WallService.clear()
    }

    @Test
    fun updateFalse() {

        val service = WallService

        service.add(
            Post(
                ownerId = 0, fromId = 0, date = 0, text = "текст", replyOwnerId = 0,
                replyPostId = 0, postType = "запись", signerId = 0, isFavorite = false
            )
        )
        service.add(
            Post(
                ownerId = 0, fromId = 0, date = 0, text = "текст", replyOwnerId = 0,
                replyPostId = 0, postType = "запись", signerId = 0, isFavorite = false
            )
        )

        val update = Post(
            id = 3, ownerId = 0, fromId = 0, date = 0, text = "текст", replyOwnerId = 0,
            replyPostId = 0, postType = "запись", signerId = 0, isFavorite = false
        )


        val result = service.update(update)

        assertFalse(result)
    }
}