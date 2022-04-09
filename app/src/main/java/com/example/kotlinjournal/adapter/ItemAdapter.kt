package com.example.kotlinjournal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinjournal.R
import com.example.kotlinjournal.model.Affirmation


class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /**
     * RecyclerView doesn't interact directly with item views, but deals with ViewHolders instead.
     * A ViewHolder represents a single list item view in RecyclerView, and can be reused
     * when possible. A ViewHolder instance holds references to the individual views within a
     * list item layout (hence the name "view holder"). This makes it easier to update the list
     * item view with new data. View holders also add information that RecyclerView uses to
     * efficiently move views around the screen.
     */
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    /**
     * The onCreateViewHolder()method is called by the layout manager to create new view holders
     * for the RecyclerView (when there are no existing view holders that can be reused).
     * Remember that a view holder represents a single list item view
     *
     * The onCreateViewHolder() method takes two parameters and returns a new ViewHolder.
     *
     * A parent parameter, which is the view group that the new list item view will be attached
     * to as a child. The parent is the RecyclerView.
     *
     * A viewType parameter which becomes important when there are multiple item view types in the
     * same RecyclerView. If you have different list item layouts displayed within the RecyclerView,
     * there are different item view types. You can only recycle views with the same item view type.
     * In your case, there is only one list item layout and one item view type, so you don't have
     * to worry about this parameter.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        /*
         In the onCreateViewHolder() method, obtain an instance of LayoutInflater from the provided
         context (context of the parent). The layout inflater knows how to inflate an XML layout
         into a hierarchy of view objects.

         Once you have a LayoutInflater object instance, add a period followed by another method
         call to inflate the actual list item view. Pass in the XML layout resource ID
         R.layout.list_item and the parent view group. The third boolean argument is attachToRoot.
         This argument needs to be false, because RecyclerView adds this item to the view hierarchy
         for you when it's time.

         Now adapterLayout holds a reference to the list item view (from which we can later find
         child views like the TextView).
         */
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * This method is called by the layout manager in order to replace the contents of a
     * list item view.
     *
     * The onBindViewHolder() method has two parameters, an ItemViewHolder previously created by the
     * onCreateViewHolder() method, and an int that represents the current item position in the
     * list. In this method, you will find the right Affirmation object from the data set based
     * on position
     *
     * Finally, you need to update all the views referenced by the view holder to reflect
     * the correct data for this item.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    /**
     * The getItemCount() method needs to return the size of your dataset.
     * Your app's data is in the dataset property that you are passing into the
     * ItemAdapter constructor, and you can get its size with size.
     */
    override fun getItemCount() = dataset.size
}