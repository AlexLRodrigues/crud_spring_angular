import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  uri = 'http://localhost:8080/estados';

  constructor(private http: HttpClient) { }

  getEstado() {
    return this
           .http
           .get(`${this.uri}`);
  }
}
