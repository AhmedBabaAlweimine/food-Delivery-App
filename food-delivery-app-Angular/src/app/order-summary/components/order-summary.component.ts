import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute, Params, Route, Router } from '@angular/router';
import { foodCataloguePage } from 'src/app/shared/models/foodCataloguePage';
import { OrderService } from '../service/order.service';
import { Order } from '../model/Order';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css'],
})
export class OrderSummaryComponent {
  orderSummary: Order;
  obj: any;
  total: any;
  showDialog: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private orderService: OrderService,
    private router: Router
  ) {}

  ngOnInit() {
    const data = this.route.snapshot.queryParams['data'];
    this.obj = JSON.parse(data);
    this.obj.userId = 1;
    this.orderSummary = this.obj;
    this.total = this.orderSummary.foodItemsList.reduce(
      (accumulator, currentValue) => {
        return accumulator + currentValue.quantity * currentValue.price;
      },
      0
    );
  }

  saveOrder() {
    this.orderService.saveOrderSumary(this.orderSummary).subscribe(
      (response) => {
        this.showDialog = true;
      },
      (error) => {
        console.error('Failed to save data:', error);
      }
    );
  }


  closeDialog(){
    this.showDialog=false;
    this.router.navigate(['/']); // navigate to default page restaurantListing
  }
}
