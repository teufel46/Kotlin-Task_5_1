data class Comments(
    val count : Int,
    val canPost : Boolean,
    val groupsCanPost : Boolean,
    val canClose : Boolean,
    val canOpen : Boolean
)

data class Copyright(
    val id : Long,
    val link : String,
    val name : String,
    val type : String
)

data class Likes(
    val count : Int,
    val userLikes : Boolean,
    val canLike : Boolean,
    val canPublish : Boolean
)

data class Reposts(
    val count : Long,
    val userReposted : Boolean
)

data class Views(
    val count : Long
)

data class Donut(
    val isDonut : Boolean,
    val paidDuration : Int,
    val placeholder : String,
    val canPublishFreeCopy : Boolean,
    val editMode : String
)

data class Post(
    var id : Long = 0,
    val ownerId : Long,
    var fromId : Long,
    var createdBy : Long,
    var date : Long,
    var text : String,
    var replyOwnerId : Long,
    var replyPostId : Long,
    var friendsOnly : Boolean,
    val comments : Comments,
    val copyright : Copyright,
    val likes : Likes,
    val reposts : Reposts,
    val views : Views,
    val postType : String,
    val signerId : Long,
    val canPin : Boolean,
    val canDelete : Boolean,
    val canEdit : Boolean,
    val isPinned : Boolean,
    val markedAsAds : Boolean,
    val isFavorite : Boolean,
    val donut : Donut,
    val postponedId : Long
)

object WallService {
    var posts: Array<Post> = emptyArray()
    var nextId: Long = 1

    fun add(post: Post) : Post {
        post.id = nextId
        posts += post
        nextId += 1
        return posts.last()
    }

    fun update(postFind: Post) : Boolean {
        for ((index, post) in posts.withIndex()){
            if (post.id == postFind.id) {
                posts[index] = postFind.copy(ownerId = post.ownerId, date = post.date)
                return true
            }
        }
        return false
    }

    fun print(){
        for (post in posts){
            println(post)
        }
        println("  NextId=$nextId")
    }

}

fun main(args: Array<String>) {

    val post1 = Post(
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
    )
    val post2 = Post(
        234,
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

    val post4 = Post(
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

    WallService.add(post1)
    WallService.add(post2)

    WallService.print()

    if (WallService.update(post4)) WallService.print()
    if (WallService.update(post3)) WallService.print()
}