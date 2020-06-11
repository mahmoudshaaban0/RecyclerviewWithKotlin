package com.mahmoudshaaban.recyclerviewwithkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mahmoudshaaban.recyclerviewwithkotlin.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

// we use the default constructor to show the dummy data ( Re   cyclerview.ViewHolder )
class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var items: List<BlogPost> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item , parent, false)

        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // we use when if we have a different viewHolders in this secnario we have one only
        when(holder){

            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

     fun submitList(blogList : List<BlogPost>){
        items = blogList

    }




    class BlogViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val blog_Image = itemView.blog_image
        val blog_Title = itemView.blog_title
        val blog_Author = itemView.blog_author

        fun bind(blogPost: BlogPost) {
            blog_Title.setText(blogPost.title)
            blog_Author.setText(blogPost.username)

            // we create requestOption object which is a glide object
            // it's an object that's used to set some defaults to any images that you're going to be setting
            val requestOptions = RequestOptions
                .placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blog_Image)
        }


    }





}