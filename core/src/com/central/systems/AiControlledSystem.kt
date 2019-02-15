package com.central.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.central.Components.PhysicsComponent
import com.central.Components.AiControlledComponent
import ktx.ashley.*

class AiControlledSystem : IteratingSystem(allOf(PhysicsComponent::class, AiControlledComponent::class).get()) {
    private val pm = mapperFor<PhysicsComponent>()

    init {

    }

    public override fun processEntity(entity: Entity, deltaTime: Float) {
        val physics = pm[entity]

        physics.vel.x = physics.topSpeed * physics.direction
    }
}