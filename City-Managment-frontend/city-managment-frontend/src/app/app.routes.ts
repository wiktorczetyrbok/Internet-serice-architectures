import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {CitizenEditComponent} from "./citizen/view/citizen-edit/citizen-edit.component";
import {CitizenViewComponent} from "./citizen/view/city-view/citizen-view.component";
import {CitizenListComponent} from "./citizen/view/citizen-list/citizen-list.component";
import {CityListComponent} from "./city/view/city-list/city-list.component";

export const routes: Routes = [
    {
        component: CityListComponent,
        path: "cities"
    },
    {
        component: CitizenListComponent,
        path: "v"
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
        RouterModule.forRoot(/*routes*/[])
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {

}
