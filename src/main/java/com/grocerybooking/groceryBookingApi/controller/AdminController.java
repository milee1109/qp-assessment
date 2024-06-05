package com.grocerybooking.groceryBookingApi.controller;

import com.grocerybooking.groceryBookingApi.Service.GroceryItemService;
import com.grocerybooking.groceryBookingApi.model.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private GroceryItemService groceryItemService;
    @GetMapping("/grocery")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItem(){
      List<GroceryItem> groceryItems = groceryItemService.getAllItems();
      return ResponseEntity.ok().body(groceryItems);

    }

    @GetMapping("/grocery/{id}")
    public ResponseEntity<Optional<GroceryItem>> getGroceryById(@PathVariable Long id){
       Optional<GroceryItem> item= groceryItemService.getItemById(id);
       return ResponseEntity.ok().body(item);
    }
    @PostMapping("/grocery")
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem groceryItem){
        GroceryItem newItem=groceryItemService.addItem(groceryItem);
        return ResponseEntity.ok().body(newItem);
    }

    @PutMapping("/grocery/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id,@RequestBody GroceryItem itemDetails){

        GroceryItem groceryItem=groceryItemService.updateGroceryItem(id,itemDetails);
        return ResponseEntity.ok().body(groceryItem);
    }
    @DeleteMapping("/grocery/{id}")
    public ResponseEntity<GroceryItem> deleteGroceryItem(@PathVariable Long id){
        groceryItemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
