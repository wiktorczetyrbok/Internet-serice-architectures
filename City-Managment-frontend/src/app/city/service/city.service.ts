import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cities} from "../model/cities";
import {CityDetails} from "../model/city-details";
import {CityForm} from "../model/city-form";

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
    return this.http.get<CityDetails>('/api/cities' + uuid);
  }

  putCity(uuid: string, request: CityForm): Observable<any> {
    return this.http.put('/api/city/' + uuid, request);
  }
}
