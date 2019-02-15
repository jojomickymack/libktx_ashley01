package com.central.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.central.views.MyGameObj
import com.central.Components.CameraFollowComponent
import com.central.Components.PhysicsComponent
import ktx.ashley.*

class CameraFollowSystem : IteratingSystem(allOf(PhysicsComponent::class, CameraFollowComponent::class).get()) {
    private val pm = mapperFor<PhysicsComponent>()

    override fun processEntity(entity: Entity, deltaTime: Float) {
        val physics = pm[entity]

        // MyGameObj.cam.position.set(physics.pos.x * MyGameObj.unitScale, physics.pos.y * MyGameObj.unitScale, 0f)
        MyGameObj.cam.position.x = physics.pos.x * MyGameObj.unitScale
        MyGameObj.cam.update()
    }
}