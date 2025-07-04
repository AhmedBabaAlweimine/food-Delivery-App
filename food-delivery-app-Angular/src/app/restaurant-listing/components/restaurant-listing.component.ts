import { Component } from '@angular/core';
import { Restaurant } from 'src/app/shared/models/Restaurant';
import { Router } from '@angular/router';
import { RestaurantService } from '../service/restaurant.service';
@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrls: ['./restaurant-listing.component.css'],
})
export class RestaurantListingComponent {
  public restaurantList: Restaurant[];

  constructor(
    private router: Router,
    private restaurantService: RestaurantService
  ) {}

  ngOnInit() {
    this.getAllRestaurants();
  }

  getAllRestaurants() {
    this.restaurantService.getAllRestaurants().subscribe((data) => {
      this.restaurantList = data;
    });
  }

  getRandomNumber(min: number, max: number) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  getRandomImage(): string {
    const imageCount = 8;
    const randomIndex = this.getRandomNumber(1, imageCount);
    return `${randomIndex}.jpg`;
  }

  onButtonClick(id?: number) {
    this.router.navigate(['/food-catalogue',id]);
  }
}
