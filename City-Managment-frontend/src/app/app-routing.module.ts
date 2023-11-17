import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CityListComponent} from "./city/view/city-list/city-list.component";
import {CitizenListComponent} from "./citizen/view/citizen-list/citizen-list.component";
import {CitizenViewComponent} from "./citizen/view/citizen-view/citizen-view.component";
import {CitizenEditComponent} from "./citizen/view/citizen-edit/citizen-edit.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: CityListComponent,
    path: "cities"
  },
  {
    component: CitizenListComponent,
    path: "citizens"
  },
  {
    component: CitizenViewComponent,
    path: "citizens/:uuid"
  }
  ,
  {
    component: CitizenEditComponent,
    path: "citizens/:uuid/edit"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
