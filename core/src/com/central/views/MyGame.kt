package com.central.views

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import ktx.app.KtxScreen
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.central.systems.*
import com.central.*
import com.central.Components.*
import ktx.ashley.*

class MyGame(val application: App) : KtxScreen {

    var ashleyEngine = Engine()

    init {
        with(ashleyEngine) {
            addSystem(PhysicsSystem())
            addSystem(RenderSystem())
            addSystem(UserControlledSystem())
            addSystem(AiControlledSystem())
            addSystem(MapControllerSystem())
            addSystem(CameraFollowSystem())
        }

        ashleyEngine.add {
            entity {
                with<TextureComponent> {
                    region = TextureRegion(Texture(Gdx.files.internal("alex.png")))
                }
                with<PhysicsComponent> {
                    w = 30f
                    h = 50f
                    pos.set(200f, 200f)
                }
                with<UserControlledComponent> {}
                with<CameraFollowComponent> {}
            }
            entity {
                with<TextureComponent> {
                    region = TextureRegion(Texture(Gdx.files.internal("enemy.png")))
                }
                with<PhysicsComponent> {
                    w = 40f
                    h = 40f
                    topSpeed = 100f
                    pos.set(100f, 200f)
                }
                with<AiControlledComponent> {}
            }
        }
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        ashleyEngine.update(delta)
    }

    override fun resize(width: Int, height: Int) {

    }
}
