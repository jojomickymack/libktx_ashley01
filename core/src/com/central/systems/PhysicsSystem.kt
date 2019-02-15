package com.central.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.central.views.MyGameObj
import com.central.Components.PhysicsComponent
import java.math.RoundingMode
import ktx.ashley.*

class PhysicsSystem : IteratingSystem(allOf(PhysicsComponent::class).get()) {

    private val pm = mapperFor<PhysicsComponent>()
    private val dampening = 0.9f

    public override fun processEntity(entity: Entity, deltaTime: Float) {
        val physics = pm[entity]

        with(physics) {
            vel.y -= MyGameObj.grav

            vel.x *= dampening
            if (Math.abs(vel.x) < 5) vel.x = 0f

            pos.x += vel.x * deltaTime
            pos.y += vel.y * deltaTime

            pos.x = pos.x.toBigDecimal().setScale(2, RoundingMode.DOWN).toFloat()
            pos.y = pos.y.toBigDecimal().setScale(2, RoundingMode.DOWN).toFloat()

            rect.set(pos.x, pos.y, w, h)
        }
    }
}