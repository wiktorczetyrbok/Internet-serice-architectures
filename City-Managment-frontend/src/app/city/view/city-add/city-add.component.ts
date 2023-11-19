// city-add.component.ts
import { Component, OnInit } from '@angular/core';
import { CityService } from '../../../city/service/city.service';
import { Router } from '@angular/router';
import { CityForm } from '../../model/city-form';

@Component({
    selector: 'app-city-add',
    templateUrl: './city-add.component.html',
    styleUrls: ['./city-add.component.css']
})
export class CityAddComponent implements OnInit {

    city: CityForm = {
        name: '',
        area: 0
    };

    constructor(
        private cityService: CityService,
        private router: Router
    ) {}

    ngOnInit() {
    }

    onSubmit(): void {
        this.cityService.postCity(this.city)
            .subscribe(() => this.router.navigate(['/cities']));
    }

}
