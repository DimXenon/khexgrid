package com.darkgravity.khexgrid.map

import com.darkgravity.khexgrid.math.OffsetCoordinate
import com.darkgravity.khexgrid.math.OffsetCoordinateType
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.subject.SubjectSpek

/**
 * @author Dan McCabe
 */
object HexagonalMapSpec : SubjectSpek<HexagonalMap>( {
    subject { HexagonalMapSharedContext.createMap(5, 5) }
    val offsetType = OffsetCoordinateType(subject.orientation)

    describe("HexagonalMap") {
        describe(".getTerrain") {
            it("returns the correct terrain for a valid location") {
                assert.that(subject.getTerrain(OffsetCoordinate(2, 2, offsetType).toCubeCoordinate()), equalTo<Terrain>(TestTerrain.DESERT))
            }
            it("returns null for an invalid location") {
                assert.that(subject.getTerrain(OffsetCoordinate(-5, -5, offsetType).toCubeCoordinate()), equalTo<Terrain?>(null))
            }
        }

        describe(".isValidLocation") {
            it("correctly identifies valid locations") {
                assert.that(subject.isValidLocation(OffsetCoordinate(0, 0, offsetType).toCubeCoordinate()), equalTo(true))
            }
            it("correctly identifies invalid locations") {
                assert.that(subject.isValidLocation(OffsetCoordinate(10, 10, offsetType).toCubeCoordinate()), equalTo(false))
            }
        }
    }
})