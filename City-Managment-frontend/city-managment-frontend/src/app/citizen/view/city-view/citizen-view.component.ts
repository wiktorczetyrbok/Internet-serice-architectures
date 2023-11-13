import {Component, OnInit} from '@angular/core';
import {CitizenService} from "../../service/citizen.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CitizenDetails} from "../../model/citizen-details";

/**
 * Preview of single citizen.
 */
@Component({
    selector: 'app-citizen-view',
    templateUrl: './citizen-view.component.html',
    styleUrls: ['./citizen-view.component.css']
})
export class CitizenViewComponent implements OnInit {

    /**
     * Single citizen.
     */
    citizen: CitizenDetails | undefined;

    /**
     *
     * @param service citizen service
     * @param route activated route
     * @param router router
     */
    constructor(private service: CitizenService, private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.service.getCitizen(params['uuid'])
                .subscribe(citizen => this.citizen = citizen)
        });
    }

}
