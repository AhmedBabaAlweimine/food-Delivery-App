import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL_Order } from 'src/app/constants/url';
import { Order } from '../model/Order';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  public appUrl = API_URL_Order + '/order/saveOrder';
  constructor(private http: HttpClient) {}

  HttpOptions = {
    header: new HttpHeaders({
      'Content-Type': 'text/plain',
      'Access-Controle-Allow-Origin': 'http://localhost:4200/',
    }),
  };

  saveOrderSumary(order: any): Observable<any> {
    return this.http.post<any>(this.appUrl, order);
  }

  private handleError(error: any) {
    console.error('An error occurred:', error);
    return throwError(error.message || error);
  }
}
