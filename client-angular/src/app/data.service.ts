import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'; // explicitly adding this method
import 'rxjs/add/operator/toPromise';
import { Url } from './url/url.model';

@Injectable()
export class DataService {

  private customersUrl = 'api/customer';  // URL to web API
  private urlHost = 'api/url';  // URL to web API
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {}
  createUrl(urlString: string): Observable<Url[]> {
    let urlStrings = urlString.split('\n');
    return this.http
      .post(this.urlHost, JSON.stringify(urlStrings), {headers: this.headers})
      .map((response) => {
        return response.json() as Url[];
      });
  }


}
