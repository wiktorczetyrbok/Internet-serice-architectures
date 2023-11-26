import {Component, OnInit} from '@angular/core';
import {CitizenService} from "../../service/citizen.service";
import {Citizens} from "../../model/citizens";
import {Citizen} from "../../model/citizen";

@Component({
    selector: 'app-citizen-list',
    templateUrl: './citizen-list.component.html',
    styleUrls: ['./citizen-list.component.css']
})
export class CitizenListComponent implements OnInit {


    citizens: Citizens | undefined;

    constructor(private service: CitizenService) {
    }

    ngOnInit(): void {
        this.service.getCitizens().subscribe(citizens => {
            this.citizens = citizens
        });
    }

    onDelete(citizen: Citizen): void {
        this.service.deleteCitizen(citizen.id).subscribe(() => this.ngOnInit());
    }

}
