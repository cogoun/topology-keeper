import { Injectable } from '@angular/core';
import { Environment } from './Environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class EnvironmentService {

  environmentUrl = "http://localhost:8080/environment";

  constructor(private http: HttpClient) { }

  getEnvironments(): Observable<Environment[]> {
    return this.http.get<Environment[]>(this.environmentUrl + "/all");
  }

  getEnvironment(id: number): Observable<Environment> {
    return this.http.get<Environment>(this.environmentUrl + "/" + id);
  }

  submit(environment: Environment): Observable<Environment> {
    return this.http.post<Environment>(this.environmentUrl, environment, httpOptions);
  }

  deleteEnvironment(id: number): Observable<Object> {
    return this.http.delete<Object>(this.environmentUrl + "/" + id);
  }

}
