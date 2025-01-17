package viewmodel.graph

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.Vertex

class VertexViewModel<V>(
    x: Dp = 0.dp,
    y: Dp = 0.dp,
    color: Color,
    val vertex: Vertex<V>,
    private val _labelVisible: State<Boolean>,
    radius: Dp = 20.dp,
) {
    private var _x = mutableStateOf(x)
    var x: Dp
        get() = _x.value
        set(value) {
            _x.value = value
        }
    private var _y = mutableStateOf(y)
    var y: Dp
        get() = _y.value
        set(value) {
            _y.value = value
        }
    private var _color = mutableStateOf(color)
    var color: Color
        get() = _color.value
        set(value) {
            _color.value = value
        }
    private var _radius = mutableStateOf(radius)
    var radius: Dp
        get() = _radius.value
        set(value) {
            _radius.value = value
        }
    val label
        get() = vertex.dBIndex.toString()
    val labelVisible
        get() = _labelVisible.value

    fun onDrag(offset: Offset) {
        _x.value += offset.x.dp
        _y.value += offset.y.dp
    }
}