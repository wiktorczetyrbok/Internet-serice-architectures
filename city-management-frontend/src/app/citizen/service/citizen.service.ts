import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from 'rxjs/operators';
import {Citizens} from "../model/citizens";
import {CitizenDetails} from "../model/citizen-details";
import {CitizenForm} from "../model/citizen-form";

@Injectable()
export class CitizenService {

    constructor(private http: HttpClient) {

    }

    getCitizens(): Observable<Citizens> {
        return this.http.get<Citizens>('/api/citizens');
    }


    getCitizen(uuid: string): Observable<CitizenDetails> {
        return this.http.get<CitizenDetails>('/api/citizens/' + uuid).pipe(
            map((citizen: CitizenDetails) => {
                return citizen;
            })
        );
    }


    deleteCitizen(uuid: string): Observable<any> {
        return this.http.delete('/api/citizens/' + uuid);
    }

    putCity(uuid: string, request: CitizenForm): Observable<any> {
        return this.http.put('/api/citizens/' + uuid, request);
    }

    postCity(request: CitizenForm): Observable<any> {
        return this.http.post('/api/citizens', request);
    }

}
