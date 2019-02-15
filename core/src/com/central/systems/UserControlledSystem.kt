package com.central.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.central.Components.PhysicsComponent
import com.central.Components.UserControlledComponent
import ktx.ashley.mapperFor

class UserControlledSystem : IteratingSystem(Family.all(PhysicsComponent::class.java, UserControlledComponent::class.java).get()) {
    private val pm = mapperFor<PhysicsComponent>()

    init {}

    public override fun processEntity(entity: Entity, deltaTime: Float) {
        val physics = pm[entity]

        with(physics) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) vel.x = -topSpeed
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) vel.x = topSpeed
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) vel.y = topSpeed
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) vel.y = -topSpeed
        }
    }
}