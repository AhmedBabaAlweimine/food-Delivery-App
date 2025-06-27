import { Component } from '@angular/core';
import { foodCataloguePage } from 'src/app/shared/models/foodCataloguePage';
import { FoodItemService } from '../service/foodItem.service';
import { FoodItem } from 'src/app/shared/models/FoodItem';
import { Restaurant } from 'src/app/shared/models/Restaurant'
import { ActivatedRoute, Params, Route, Router } from '@angular/router';

@Component({
  selector: 'app-food-catalogue',
  templateUrl: './food-catalogue.component.html',
  styleUrls: ['./food-catalogue.component.css'],
})
export class FoodCatalogueComponent {
  
  public foodItemResponse: foodCataloguePage;
  restaurantId: number;
  foodItemCart: FoodItem[] = [];
  orderSummary: foodCataloguePage;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private foodItemService: FoodItemService
  ) {}

  ngOnInit() {
    this.route.params.subscribe((param:Params) => {
      this.restaurantId = +param['id'];
    });
    this.getFoodItemByRestaurantById();
  }
  getFoodItemByRestaurantById() {
    this.foodItemService
      .getFoodItemByRestaurant(this.restaurantId)
      .subscribe((data) => {
        this.foodItemResponse = data;
      });
  }

  increment(food: any) {
    food.quantity++;
    const index = this.foodItemCart.findIndex((item) => item.id === food.id);
    if (index == -1) {
      //if record does not exist, add it to array
      this.foodItemCart.push(food);
    } else {
      // if record exists , update it in array
      this.foodItemCart[index] = food;
    }
  }


  decrement(food: any) {
    if (food.quantity > 0) {
      food.quantity--;

      const index = this.foodItemCart.findIndex((item) => item.id === food.id);
      if (this.foodItemCart[index].quantity == 0) {
        this.foodItemCart.splice(index, 1);
      } else {
        // if record exists , update it in array
        this.foodItemCart[index] = food;
      }
    }
  }

  onCheckOut() {
    this.foodItemCart;
    this.orderSummary = {
      foodItemsList: [],
      restaurant: null
    }
    this.orderSummary.foodItemsList = this.foodItemCart;
    this.orderSummary.restaurant = this.foodItemResponse.restaurant;
    this.router.navigate(['/orderSummary'], { queryParams: { data: JSON.stringify(this.orderSummary) } });
  }
}
