# Ashley Example Refactored So It Uses Ktx-Ashley

Ktx-ashley offers some really nice extensions that simplify entity creation into a dsl, and make it so creating a component 
mapper and accessing an entity with a cleaner syntax (something that's done over and over in systems).

This game has only the bare essentials to have characters that move around and collide with a tiled map and are affected by 
gravity. Each system is almost empty with the exception of the MapControllerSystem which has all of the collision detection 
and tile getting code.

Take a look at the article below for further explanation of the code.

[https://jojomickymack.gitlab.io/reverie/post/ashley_ecs](https://jojomickymack.gitlab.io/reverie/post/ashley_ecs)
