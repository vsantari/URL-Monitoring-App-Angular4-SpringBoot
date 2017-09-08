import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { DataService } from './data.service';
import { URLComponent } from './url/url.component';
import { CdkTableModule } from '@angular/cdk/table';
import { MdTableModule, MdSortModule, MdInputModule, MdProgressBarModule } from '@angular/material';
import {enableProdMode} from '@angular/core';

@NgModule({
  declarations: [
    AppComponent,
    URLComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    MdTableModule,
    CdkTableModule,
    MdSortModule,
    CdkTableModule,
    MdInputModule,
    MdProgressBarModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
