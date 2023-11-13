import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Citizens} from "../model/citizens";
import {CitizenDetails} from "../model/citizen-details";
import {CitizenForm} from "../model/citizen-form";

@Injectable()
export class CitizenService {

    constructor(private http: HttpClient) {

    }

    getCitizens(): Observable<Citizens> {
        return this.http.get<Citizens>('/cities');
    }


    getCitizen(uuid: string): Observable<CitizenDetails> {
        return this.http.get<CitizenDetails>('/citizen/' + uuid);
    }


    deleteCitizen(uuid: string): Observable<any> {
        return this.http.delete('/citizen/' + uuid);
    }

    putCity(uuid: string, request: CitizenForm): Observable<any> {
        return this.http.put('/citizen/' + uuid, request);
    }

}
