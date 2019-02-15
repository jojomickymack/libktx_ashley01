package com.central.Components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class AiControlledComponent : Component

class UserControlledComponent : Component

class CameraFollowComponent : Component

class PhysicsComponent : Component {
    val vel = Vector2()
    val pos = Vector2()
    val scl = Vector2(1.0f, 1.0f)
    var w = 50f
    var h = 50f
    var rot = 0.0f
    var rect = Rectangle()
    var direction = 1
    var topSpeed = 200f
}

class TextureComponent : Component {
    var defaultTex = Texture("default.png")
    var region = TextureRegion(defaultTex, 0, 0, defaultTex.width, defaultTex.height)
}