import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun updateExisting() {
        val service = WallService
        val post1 = Post(
            1,
            12345689,
            12345689,
            111111,
            1460041200,
            "Текст поста",
            12345689,
            6765,
            true,
            Comments(123, true, false, false,true),
            Copyright(23452784, "dfdfdsf","Текст","тип"),
            Likes(4873, true, true,true),
            Reposts(23, false),
            Views(21),
            "post", //post, copy, reply, postpone, suggest.
            12786,
            true,
            true,
            false,
            true,
            false,
            false,
            Donut(true, 223,"placeholder", true, "all"),
            1
        )
        val post2 = Post(
            2,
            12345665,
            12345665,
            111111,
            1460041200,
            "Текст поста",
            12345689,
            6765,
            true,
            Comments(123, true, false, false,true),
            Copyright(23452784, "dfdfdsf","Текст","тип"),
            Likes(4873, true, true,true),
            Reposts(23, false),
            Views(21),
            "post", //post, copy, reply, postpone, suggest.
            12786,
            true,
            true,
            false,
            true,
            false,
            false,
            Donut(true, 223,"placeholder", true, "all"),
            1
        )
        val post3 = Post(
            3,
            12345670,
            12345555,
            111111,
            1460041200,
            "Текст поста",
            12345689,
            6765,
            false,
            Comments(123, true, false, false,true),
            Copyright(23452784, "dfdfdsf","Текст","тип"),
            Likes(4873, true, true,true),
            Reposts(23, false),
            Views(21),
            "post", //post, copy, reply, postpone, suggest.
            12786,
            true,
            true,
            false,
            true,
            false,
            false,
            Donut(true, 223,"placeholder", true, "all"),
            1
        )
        val update = Post(
            2,
            99999999,
            99999999,
            99999999,
            1460041200,
            "Update",
            99999999,
            99999999,
            true,
            Comments(99999999, true, false, false,true),
            Copyright(99999999, "Update","Update","Update"),
            Likes(99999999, true, true,true),
            Reposts(99999999, false),
            Views(99999999),
            "post", //post, copy, reply, postpone, suggest.
            99999999,
            true,
            true,
            false,
            true,
            false,
            false,
            Donut(true, 99999999,"Update", true, "Update"),
            1
        )
        service.add(post1)
        service.add(post2)
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        val post1 = Post(
            1,
            12345689,
            12345689,
            111111,
            1460041200,
            "Текст поста",
            12345689,
            6765,
            true,
            Comments(123, true, false, false,true),
            Copyright(23452784, "dfdfdsf","Текст","тип"),
            Likes(4873, true, true,true),
            Reposts(23, false),
            Views(21),
            "post", //post, copy, reply, postpone, suggest.
            12786,
            true,
            true,
            false,
            true,
            false,
            false,
            Donut(true, 223,"placeholder", true, "all"),
            1
        )
        val post2 = Post(
            2,
            12345665,
            12345665,
            111111,
            1460041200,
            "Текст поста",
            12345689,
            6765,
            true,
            Comments(123, true, false, false,true),
            Copyright(23452784, "dfdfdsf","Текст","тип"),
            Likes(4873, true, true,true),
            Reposts(23, false),
            Views(21),
            "post", //post, copy, reply, postpone, suggest.
            12786,
            true,
            true,
            false,
            true,
            false,
            false,
            Donut(true, 223,"placeholder", true, "all"),
            1
        )
        val post3 = Post(
            789,
            12345670,
            12345555,
            111111,
            1460041200,
            "Текст поста",
            12345689,
            6765,
            false,
            Comments(123, true, false, false,true),
            Copyright(23452784, "dfdfdsf","Текст","тип"),
            Likes(4873, true, true,true),
            Reposts(23, false),
            Views(21),
            "post", //post, copy, reply, postpone, suggest.
            12786,
            true,
            true,
            false,
            true,
            false,
            false,
            Donut(true, 223,"placeholder", true, "all"),
            1
        )
        val update = Post(
            256,
            99999999,
            99999999,
            99999999,
            1460041200,
            "Update",
            99999999,
            99999999,
            true,
            Comments(99999999, true, false, false,true),
            Copyright(99999999, "Update","Update","Update"),
            Likes(99999999, true, true,true),
            Reposts(99999999, false),
            Views(99999999),
            "post", //post, copy, reply, postpone, suggest.
            99999999,
            true,
            true,
            false,
            true,
            false,
            false,
            Donut(true, 99999999,"Update", true, "Update"),
            1
        )

        service.add(post1)
        service.add(post2)
        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun add() {
        val service = WallService
        val postNew = service.add(Post(
            123,
            12345689,
            12345689,
            111111,
            1460041200,
            "Текст поста",
            12345689,
            6765,
            true,
            Comments(123, true, false, false,true),
            Copyright(23452784, "dfdfdsf","Текст","тип"),
            Likes(4873, true, true,true),
            Reposts(23, false),
            Views(21),
            "post", //post, copy, reply, postpone, suggest.
            12786,
            true,
            true,
            false,
            true,
            false,
            false,
            Donut(true, 223,"placeholder", true, "all"),
            1
        ))

        assertTrue(postNew.id > 0)
    }
}