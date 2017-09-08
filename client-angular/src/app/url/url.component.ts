import { Url } from './url.model';
import { DataService } from '../data.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Location } from '@angular/common';
import { Observable } from 'rxjs/Observable';
import { DataSource } from '@angular/cdk/collections';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/observable/fromEvent';
import { MdSort } from '@angular/material';

@Component({
  selector: 'app-create-url',
  templateUrl: './url.component.html',
  styleUrls: ['./url.component.css']
})
export class URLComponent implements OnInit {

  @ViewChild(MdSort) sort: MdSort;
  urls: Url[];
  urlStrings: string;
  submitted = false;
  activeSpinner = false;
  displayedColumns = [ 'timestamp', 'url', 'error', 'status', 'responseTime', 'retry'];

  dataSource: ExampleDataSource | null;
  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

   create(): Observable<Url[]> {
    return this.dataService.createUrl(this.urlStrings);
  }

 onSubmit() {
   this.submitted = true;
   this.activeSpinner = true;
   this.create().subscribe((urls) => {
     this.urls = urls;
     this.dataSource = new ExampleDataSource(this, this.sort);
     this.activeSpinner = false;
     this.submitted = false;
   });
 }
}

export class ExampleDataSource extends DataSource<any> {
  constructor(private urlComponent: URLComponent, private _sort: MdSort) {
    super();
  }
  connect(): Observable<Url[]> {

    const displayDataChanges = [
      this.urlComponent.urls,
      this._sort.mdSortChange
    ];

    return Observable.merge(...displayDataChanges).map(() => {
      return this.getSortedData();
    });
  }

  disconnect() {}
    getSortedData(): Url[] {
      const data = this.urlComponent.urls.slice();
      if (!this._sort.active || this._sort.direction === '') { return data; }

      return data.sort((a, b) => {
        let propertyA: number|string = '';
        let propertyB: number|string = '';

        switch (this._sort.active) {
          case 'timestamp': [propertyA, propertyB] = [a.timestamp, b.timestamp]; break;
          case 'url': [propertyA, propertyB] = [a.url, b.url]; break;
          case 'status': [propertyA, propertyB] = [a.status, b.status]; break;
          case 'error': [propertyA, propertyB] = [a.error, b.error]; break;
          case 'responseTime': [propertyA, propertyB] = [a.responseTime, b.responseTime]; break;
          case 'retry': [propertyA, propertyB] = [a.retry, b.retry]; break;
        }

        let valueA = isNaN(+propertyA) ? propertyA : +propertyA;
        let valueB = isNaN(+propertyB) ? propertyB : +propertyB;

        return (valueA < valueB ? -1 : 1) * (this._sort.direction == 'asc' ? 1 : -1);
      });
    }

  }

