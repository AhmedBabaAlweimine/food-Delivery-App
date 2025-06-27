import { FoodItem } from 'src/app/shared/models/FoodItem';
import { Restaurant } from 'src/app/shared/models/Restaurant';

export interface Order {
  restaurant: Restaurant;
  foodItemsList: FoodItem[];
  userId: number;
}
