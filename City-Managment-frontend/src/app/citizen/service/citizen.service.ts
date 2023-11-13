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
        return this.http.get<Citizens>('http://localhost:8081/citizens');
    }


    getCitizen(uuid: string): Observable<CitizenDetails> {
        return this.http.get<CitizenDetails>('http://localhost:8081/citizens/' + uuid);
    }


    deleteCitizen(uuid: string): Observable<any> {
        return this.http.delete('http://localhost:8081/citizens/' + uuid);
    }

    putCity(uuid: string, request: CitizenForm): Observable<any> {
        return this.http.put('http://localhost:8081/citizens/' + uuid, request);
    }

}
