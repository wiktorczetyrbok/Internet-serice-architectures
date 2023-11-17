import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CityListComponent} from "./city/view/city-list/city-list.component";
import {CitizenListComponent} from "./citizen/view/citizen-list/citizen-list.component";
import {CitizenViewComponent} from "./citizen/view/citizen-view/citizen-view.component";
import {CitizenEditComponent} from "./citizen/view/citizen-edit/citizen-edit.component";
import {CityViewComponent} from "./city/view/city-view/city-view.component";
import {CityEditComponent} from "./city/view/city-edit/city-edit.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: CityListComponent,
    path: "cities"
  },
  {
    component: CityViewComponent,
    path: "cities/:uuid"
  },
  {
    component: CityEditComponent,
    path: "cities/:uuid/edit"
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
