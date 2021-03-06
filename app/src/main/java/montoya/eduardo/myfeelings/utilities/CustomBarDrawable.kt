package montoya.eduardo.myfeelings.utilities

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import montoya.eduardo.myfeelings.R

class CustomBarDrawable: Drawable {
    var coordenadas: RectF? = null
    var context: Context? = null
    var emocion: Emociones? = null



    constructor(context: Context, emocion: Emociones){
        this.context = context
        this.emocion = emocion
    }

    override fun draw(canvas: Canvas) {
        val fondo: Paint = Paint()
        fondo.style = Paint.Style.STROKE
        fondo.isAntiAlias = true
        fondo.color = context?.resources?.getColor(R.color.gray) ?: R.color.gray

        val ancho: Float = (canvas.width - 10).toFloat()
        val alto: Float = (canvas.height - 10).toFloat()

        coordenadas = RectF(0.0F, 0.0F, ancho, alto)

        canvas.drawRect(coordenadas!!, fondo)

        if (this.emocion!= null) {
            val porcentaje: Float = this.emocion!!.porcentaje * (canvas.width -10)/100
            val coordenadas2 = RectF(0.0F,0.0F, porcentaje, alto)

            val seccion: Paint = Paint()
            seccion.style = Paint.Style.FILL
            seccion.isAntiAlias = true
            seccion.color = ContextCompat.getColor(this.context!!, emocion!!.color)

            canvas.drawRect(coordenadas2!!, seccion)
        }
    }

    override fun setAlpha(alpha: Int) {  }

    override fun setColorFilter(colorFilter: ColorFilter?) {  }

    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }
}