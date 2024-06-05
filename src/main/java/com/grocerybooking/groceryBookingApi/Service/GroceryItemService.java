package com.grocerybooking.groceryBookingApi.Service;

import com.grocerybooking.groceryBookingApi.model.GroceryItem;
import com.grocerybooking.groceryBookingApi.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepository repository;

    public GroceryItem updateGroceryItem(Long id, GroceryItem itemDetails) {
        Optional<GroceryItem> item = getItemById(id);
        if (item.isPresent()) {
            GroceryItem groceryItem=item.get();
            groceryItem.setName(itemDetails.getName());
            groceryItem.setPrice(itemDetails.getPrice());
            groceryItem.setQuantity(itemDetails.getQuantity());
            return repository.save(groceryItem);
        }
        return null;
    }
    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<GroceryItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public GroceryItem addItem(GroceryItem item) {
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }


}
