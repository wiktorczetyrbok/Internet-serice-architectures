import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {mergeMap, Observable} from "rxjs";
import {Cities} from "../model/cities";
import {CityDetails} from "../model/city-details";
import {CityForm} from "../model/city-form";
import {Citizens} from "../../citizen/model/citizens";
import {map} from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class CityService {

    constructor(private http: HttpClient) {
    }

    getCities(): Observable<Cities> {
        return this.http.get<Cities>('/api/cities');
    }

    deleteCity(uuid: string): Observable<any> {
        return this.http.delete('/api/cities/' + uuid);
    }

    getCity(uuid: string): Observable<CityDetails> {
        return this.http.get<CityDetails>('/api/cities/' + uuid).pipe(
            mergeMap((city: CityDetails) => {
                return this.http.get<Citizens>('/api/citizens', {params: {city_id: uuid}}).pipe(
                    map((citizens: Citizens) => {
                        city.citizens = citizens;
                        return city;
                    })
                );
            })
        );
    }

    putCity(uuid: string, request: CityForm): Observable<any> {
        return this.http.put('/api/cities/' + uuid, request);
    }

    postCity(request: CityForm): Observable<any> {
        return this.http.post('/api/cities', request);
    }
}
