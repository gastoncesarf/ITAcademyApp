package ml.itacademy.app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import ml.itacademy.app.R;
import ml.itacademy.app.dto.Item;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private final List<Item> itemsList;

    public ItemsAdapter(final List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    @NonNull
    public ItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new ItemViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {
        final Item item = itemsList.get(position);
        holder.bindObjectValue(item);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    static final class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        ImageView itemImage;
        View itemView;

        ItemViewHolder(final View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemName = itemView.findViewById(R.id.item_name);
            itemImage = itemView.findViewById(R.id.item_image);
        }

        void bindObjectValue(final Item item) {
            itemName.setText(item.title);
            Picasso.with(itemView.getContext())
                .load(item.thumbnail)
                .resize(90,90)
                .into(itemImage);
        }
    }
}