import {Component, OnInit} from '@angular/core';
import {CitizenService} from "../../service/citizen.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CitizenDetails} from "../../model/citizen-details";

@Component({
    selector: 'app-citizen-view',
    templateUrl: './citizen-view.component.html',
    styleUrls: ['./citizen-view.component.css']
})
export class CitizenViewComponent implements OnInit {

    citizen: CitizenDetails | undefined;


    constructor(private service: CitizenService,
                private route: ActivatedRoute,
                private router: Router) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.service.getCitizen(params['uuid'])
                .subscribe(citizen => {
                    this.citizen = citizen
                })
        });
    }

    onDelete(citizen: CitizenDetails) {
        this.service.deleteCitizen(citizen.id).subscribe(() => {
            this.router.navigate(['/citizens']);
        });
    }
}
