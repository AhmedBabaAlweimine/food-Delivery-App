import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable,throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {API_URL_RL} from 'src/app/constants/url';
 @Injectable({
  providedIn: 'root'
})
export class RestaurantService {
 private appUrl=API_URL_RL+'/restaurant'

  constructor(private http:HttpClient) { }

  getAllRestaurants(): Observable<any> {
    return this.http.get<any>(`${this.appUrl}`)
     .pipe(catchError(this.handleError)
     );
    }

  private handleError (error:any){
    console.error('An error occurred:',error);
    return throwError(error.message || error);
    }
}
