package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladimirarreola.recyclervlad.R
import com.vladimirarreola.recyclervlad.modelo.nota

class NotasAdapter(notas:ArrayList<nota>, contexto:Context):RecyclerView.Adapter<NotasAdapter.ViewHolder>(){
    var notas:ArrayList<nota>?=null
    var contexto:Context?=null

    init{
        this.notas = notas
        this.contexto = contexto
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasAdapter.ViewHolder {
    val vistaNota:View = LayoutInflater.from(contexto).inflate(R.layout.nota_layout, parent, false)
    val notaViewHolder = ViewHolder(vistaNota)
        vistaNota.tag = notaViewHolder
        return  notaViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitulo.text = notas!![position].Titulo
        holder.tvDescripcion.text = notas!![position].descripcion
    }

    override fun getItemCount(): Int {
        return this.notas!!.count()
    }

    class ViewHolder(v:View):RecyclerView.ViewHolder(v){
        lateinit var tvTitulo:TextView
        lateinit var tvDescripcion:TextView

        init{
            tvTitulo = v.findViewById(R.id.tvTitulo)
            tvDescripcion = v.findViewById(R.id.tvDescripcion)
        }

    }
}