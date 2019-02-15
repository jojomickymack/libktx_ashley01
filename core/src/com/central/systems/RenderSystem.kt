package com.central.systems

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.gdx.utils.Array
import com.central.views.MyGameObj
import com.central.Components.*
import ktx.ashley.allOf
import ktx.ashley.mapperFor
import ktx.graphics.*


class RenderSystem : EntitySystem() {
    private var textures = ImmutableArray(Array<Entity>())

    private val mm = mapperFor<PhysicsComponent>()
    private val tm = mapperFor<TextureComponent>()

    init {}

    override fun addedToEngine(engine: Engine) {
        textures = engine.getEntitiesFor(allOf(TextureComponent::class).get())
    }

    override fun update(deltaTime: Float) {
        val map = engine.getSystem(MapControllerSystem::class.java)
        map.mr.setView(MyGameObj.cam)
        map.mr.render()

        MyGameObj.stg.batch.projectionMatrix = MyGameObj.cam.combined

        with(MyGameObj.stg.batch) {
            use {

                textures.forEach {
                    val physics = mm.get(it)
                    val texture = tm.get(it)

                    with(physics) {
                        draw(texture.region,
                                pos.x * MyGameObj.unitScale, pos.y * MyGameObj.unitScale,
                                w * MyGameObj.unitScale, h * MyGameObj.unitScale,
                                w * MyGameObj.unitScale, h * MyGameObj.unitScale,
                                scl.x, scl.y,
                                rot)
                    }
                }
            }
        }
    }
}