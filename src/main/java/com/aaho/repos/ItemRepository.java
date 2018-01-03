package com.aaho.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaho.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
