package com.aaho.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaho.models.UserItem;

public interface UserItemRepository extends JpaRepository<UserItem, Long> {

	List<UserItem> findByUserId(Long userid);

}
