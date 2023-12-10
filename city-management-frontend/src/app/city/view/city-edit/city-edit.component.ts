import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CityService} from "../../../city/service/city.service";
import {Cities} from "../../../city/model/cities";
import {CityForm} from "../../model/city-form";

@Component({
    selector: 'app-citizen-edit',
    templateUrl: './city-edit.component.html',
    styleUrls: ['./city-edit.component.css']
})
export class CityEditComponent implements OnInit {


    uuid: string | undefined;

    city: CityForm | undefined;


    original: CityForm | undefined;

    cities: Cities | undefined;

    constructor(
        private cityService: CityService,
        private route: ActivatedRoute,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {

            this.cityService.getCity(params['uuid'])
                .subscribe(city => {
                    this.uuid = city.id;
                    this.city = {
                        name: city.name,
                        area: city.area,
                    };

                    this.original = {...this.city};
                });
        });
    }

    onSubmit(): void {
        this.cityService.putCity(this.uuid!, this.city!)
            .subscribe(() => this.router.navigate(['/cities', this.uuid]));
    }

}
