import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun updateExisting() {
        val service = WallService
        service.add(Post(0, 12345689, 12345689))
        service.add(Post(0, 12345665, 12345665))
        service.add(Post(0, 12345670, 12345555))
        val update = Post(2, 12345665, 12345665)
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        service.add(Post(0, 12345689, 12345689))
        service.add(Post(0, 12345665, 12345665))
        service.add(Post(0, 12345670, 12345555))


        // создаём информацию об обновлении
        val update = Post(234, 12345665, 12345665)

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test
    fun add() {
        val service = WallService
        service.add(Post(0, 12345689, 12345689))
        assertTrue(service.posts[0].id > 0)
    }

}