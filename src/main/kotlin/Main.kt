/*data class Comments(
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
*/
data class Post(
    var id : Long = 0,
    val ownerId : Long,
    var fromId : Long,
 /*   val createdBy : Long,
    val date : Long,
    val text : String,
    val replyOwnerId : Long,
    val replyPostId : Long,
    val friendsOnly : Boolean,
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

  */
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

    fun update(post: Post) : Boolean {
        println("====WallService.update===========================")
        val idFind: Long = post.id
        for (post in posts) {
            if (post.id == idFind) {
                post.fromId = post.fromId + 1

                return true
            }
        }
        return false
    }

    fun print(){
        println("====WallService.print============================")
        println("  Posts")
        for (post in posts){
            println(post)
        }
        println("  NextId=$nextId")
    }

}



fun main(args: Array<String>) {

    val post1 = Post(123, 12345689, 12345689)
    val post2 = Post(234, 12345665, 12345665)
    val post3 = Post(789, 12345670, 12345555)

    WallService.add(post1)
    WallService.add(post2)

    WallService.print()

    if (WallService.update(post2)) WallService.print()
    if (WallService.update(post3)) WallService.print()




}