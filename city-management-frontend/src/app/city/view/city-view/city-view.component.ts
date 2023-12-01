import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CityDetails} from "../../model/city-details";
import {CityService} from "../../service/city.service";

@Component({
    selector: 'app-city-view',
    templateUrl: './city-view.component.html',
    styleUrls: ['./city-view.component.css']
})
export class CityViewComponent implements OnInit {

    city: CityDetails | undefined;

    constructor(private service: CityService, private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.service.getCity(params['uuid'])
                .subscribe(city => {
                    this.city = city
                })
        });
    }

    onDelete(city: CityDetails) {
        this.service.deleteCity(city.id).subscribe(() => {
            this.router.navigate(['/cities']);
        });
    }
}
