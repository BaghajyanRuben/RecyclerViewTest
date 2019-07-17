package com.photo.scrollabletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RecyclerView recyclerView = findViewById(R.id.recycler_view);

		LinearLayoutManager linearLayoutManager =
				new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

		GridLayoutManager glm = new GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false);
		recyclerView.setLayoutManager(linearLayoutManager);

		UserAdapter userAdapter = new UserAdapter();
		recyclerView.setAdapter(userAdapter);
		recyclerView.setItemViewCacheSize(6);

		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			users.add(new User("user " + i, "user"+i+"@gmail.com", ""));
		}

		userAdapter.addAll(users);



	}
}
