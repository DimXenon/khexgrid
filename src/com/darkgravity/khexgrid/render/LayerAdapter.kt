package com.darkgravity.khexgrid.render

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch
import com.darkgravity.khexgrid.map.HexagonalTile

/**
 * @author Dan McCabe
 */
open class LayerAdapter : Layer {
    override fun use(batch: PolygonSpriteBatch, action: () -> Unit) {
        begin(batch)
        action()
        end(batch)
    }

    override fun begin(batch: PolygonSpriteBatch) {}

    override fun render(batch: PolygonSpriteBatch, tiles: Collection<HexagonalTile>) {}

    override fun end(batch: PolygonSpriteBatch) {}
}
