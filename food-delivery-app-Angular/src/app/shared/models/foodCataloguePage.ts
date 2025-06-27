import { FoodItem } from "./FoodItem";
import { Restaurant } from "./Restaurant";

export interface foodCataloguePage{
   foodItemsList: FoodItem[];
   restaurant: Restaurant; 
}