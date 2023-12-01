// citizen-add.component.ts
import {Component, OnInit} from '@angular/core';
import {CitizenService} from '../../service/citizen.service';
import {Router} from '@angular/router';
import {CitizenForm} from '../../model/citizen-form';
import {CityService} from "../../../city/service/city.service";
import {Cities} from "../../../city/model/cities";

@Component({
    selector: 'app-citizen-add',
    templateUrl: './citizen-add.component.html',
    styleUrls: ['./citizen-add.component.css']
})
export class CitizenAddComponent implements OnInit {

    citizen: CitizenForm = {
        age: 0,
        city_id: '',
        name: ''
    };

    cities: Cities | undefined;

    constructor(
        private citizenService: CitizenService,
        private cityService: CityService,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.cityService.getCities()
            .subscribe(cities => this.cities = cities);
    }

    onSubmit(): void {
        this.citizenService.postCity(this.citizen)
            .subscribe(() => this.router.navigate(['/citizens']));
    }

}
