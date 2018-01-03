package com.aaho.services;

import java.util.List;

import com.aaho.models.Item;

public interface UserItemServices {
List<Item> getItemsByUser();
List<Item> getItemsByTeam();

}
