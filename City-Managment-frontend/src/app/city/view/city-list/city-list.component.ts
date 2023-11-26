import {Component, OnInit} from '@angular/core';

import {Cities} from "../../model/cities";
import {CityService} from "../../service/city.service";
import {City} from "../../model/city";

/**
 * Navigable view with list of all cities.
 */
@Component({
    selector: 'app-city-list',
    templateUrl: './city-list.component.html',
    styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {

    /**
     * Available cities.
     */
    cities: Cities | undefined;

    /**
     * @param service cities service
     */
    constructor(private service: CityService) {
    }

    ngOnInit(): void {
        this.service.getCities().subscribe(cities => this.cities = cities);
    }

    /**
     * Deletes selected city.
     *
     * @param city city to be removed
     */
    onDelete(city: City): void {
        this.service.deleteCity(city.id).subscribe(() => this.ngOnInit());
    }

}
