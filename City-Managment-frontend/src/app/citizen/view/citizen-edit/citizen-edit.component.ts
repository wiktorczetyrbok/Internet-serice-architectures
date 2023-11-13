import {Component, OnInit} from '@angular/core';
import {CitizenService} from '../../service/citizen.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CitizenForm} from '../../model/citizen-form';
import {CityService} from "../../../city/service/city.service";
import {Cities} from "../../../city/model/cities";

@Component({
    selector: 'app-citizen-edit',
    templateUrl: './citizen-edit.component.html',
    styleUrls: ['./citizen-edit.component.css']
})
export class CitizenEditComponent implements OnInit {

    /**
     * Character's id.
     */
    uuid: string | undefined;

    /**
     * Single citizen.
     */
    citizen: CitizenForm | undefined;

    /**
     * Single citizen.
     */
    original: CitizenForm | undefined;

    cities: Cities | undefined;

    /**
     * @param characterService citizen service
     * @param cityService city service
     * @param route activated route
     * @param router router
     */
    constructor(
        private citizenService: CitizenService,
        private cityService: CityService,
        private route: ActivatedRoute,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.cityService.getCities()
                .subscribe(cities => this.cities = cities);

            this.citizenService.getCitizen(params['uuid'])
                .subscribe(citizen => {
                    this.uuid = citizen.id;
                    this.citizen = {
                        name: citizen.name,
                        age: citizen.age,
                        city: citizen.city.id
                    };
                    this.original = {...this.citizen};
                });
        });
    }

    /**
     * Updates citizen.
     */
    onSubmit(): void {
        this.citizenService.putCity(this.uuid!, this.citizen!)
            .subscribe(() => this.router.navigate(['/citizens']));
    }

}
