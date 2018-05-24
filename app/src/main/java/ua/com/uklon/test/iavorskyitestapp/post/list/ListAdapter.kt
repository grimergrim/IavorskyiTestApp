package ua.com.uklon.test.iavorskyitestapp.post.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_list_content.view.*
import ua.com.uklon.test.iavorskyitestapp.R
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post

class ListAdapter(private val listActivity: ListContract.ListActivityCallback, private val values: List<Post>) :
        RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val id = v.tag as Int
            val post: Post = values.single { user -> user.id == id }
            listActivity.startActivity(post)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.title
        holder.contentView.text = item.body
        with(holder.itemView) {
            tag = item.id
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.title
        val contentView: TextView = view.content
    }
}