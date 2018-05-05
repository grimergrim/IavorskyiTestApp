package ua.com.uklon.test.iavorskyitestapp.post.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_detail_content.view.*
import ua.com.uklon.test.iavorskyitestapp.R
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment

class DetailAdapter(private val values: List<Comment>) :
        RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_detail_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nameView.text = item.name
        holder.emailView.text = item.email
        holder.commentView.text = item.body
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.name
        val emailView: TextView = view.email
        val commentView: TextView = view.comment
    }
}