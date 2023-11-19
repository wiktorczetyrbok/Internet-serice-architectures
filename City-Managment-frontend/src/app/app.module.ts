import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FooterComponent} from './component/footer/footer.component';
import {HeaderComponent} from './component/header/header.component';
import {NavComponent} from './component/nav/nav.component';
import {MainComponent} from './component/main/main.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";

import {FormsModule} from "@angular/forms";
import {CityListComponent} from "./city/view/city-list/city-list.component";
import {CitizenListComponent} from "./citizen/view/citizen-list/citizen-list.component";
import {CitizenViewComponent} from "./citizen/view/citizen-view/citizen-view.component";
import {CitizenEditComponent} from "./citizen/view/citizen-edit/citizen-edit.component";
import {CitizenService} from "./citizen/service/citizen.service";
import {CityService} from "./city/service/city.service";
import {ErrorInterceptor} from "../error.interceptor";
import {CityEditComponent} from "./city/view/city-edit/city-edit.component";
import {CityViewComponent} from "./city/view/city-view/city-view.component";
import { CitizenAddComponent } from './citizen/view/citizen-add/citizen-add.component';
import { CityAddComponent } from './city/view/city-add/city-add.component';


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    CityListComponent,
    CityEditComponent,
    CityViewComponent,
    CityAddComponent,
    CitizenListComponent,
    CitizenViewComponent,
    CitizenEditComponent,
    CitizenAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    CityService,
    CitizenService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptor,
      multi: true
    }
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
