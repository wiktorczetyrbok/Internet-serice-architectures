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


  uuid: string | undefined;

  citizen: CitizenForm | undefined;


  original: CitizenForm | undefined;

  cities: Cities | undefined;

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
            city: citizen.city
          };
          this.original = {...this.citizen};
        });
    });
  }

  onSubmit(): void {
    this.citizenService.putCity(this.uuid!, this.citizen!)
      .subscribe(() => this.router.navigate(['/citizens']));
  }

}
