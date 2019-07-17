package com.photo.scrollabletest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

	private List<User> items;

	public UserAdapter(){
		items = new ArrayList();
	}

	public void addAll(List<User> data){
		items.addAll(data);
		notifyDataSetChanged();
	}

	@Override
	public int getItemViewType(int position) {
		if (position % 2 == 0){
			return R.layout.layout_item_user;
		}
		return R.layout.layout_item_user_revers;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		Log.d("aksjdh", "onCreateViewHolder ");

		return new MyViewHolder(LayoutInflater
				.from(parent.getContext())
				.inflate(viewType,
						parent,
						false));
	}


	@Override
	public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
		super.onDetachedFromRecyclerView(recyclerView);
		Log.d("aksjdh", "onDetachedFromRecyclerView");

	}

	@Override
	public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
		Log.d("aksjdh", "onAttachedToRecyclerView");

		super.onAttachedToRecyclerView(recyclerView);
	}

	@Override
	public void onViewRecycled(@NonNull MyViewHolder holder) {
		Log.d("aksjdh", "onViewRecycled " +holder.getAdapterPosition());
		super.onViewRecycled(holder);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
		int index = 0;
		if (position < items.size()){
			index = position;
		} else {
			index = position % items.size();
		}
		Log.d("aksjdh", "onBindViewHolder "  + index);

		User user = items.get(index);
		myViewHolder.bind(user);
	}

	@Override
	public int getItemCount() {
		return Integer.MAX_VALUE;
	}

	static class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView name;
		private TextView email;
		private ImageView avatar;


		public MyViewHolder(@NonNull View itemView) {
			super(itemView);

			name = itemView.findViewById(R.id.tv_name);
			email = itemView.findViewById(R.id.tv_email);
			avatar = itemView.findViewById(R.id.avatar);
		}

		public void bind(User user){
			name.setText(user.getName());
			email.setText(user.getEmail());
			avatar.setImageDrawable(avatar.getContext()
					.getDrawable(R.mipmap.ic_launcher));
		}


	}

}
